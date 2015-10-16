package com.onlinemarketplace.rest.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.AntPathMatcher;

public class OptionalPathMatcher extends AntPathMatcher {

	public OptionalPathMatcher() {
		// TODO Auto-generated constructor stub
	}

	public OptionalPathMatcher(String pathSeparator) {
		super(pathSeparator);
		// TODO Auto-generated constructor stub
	}
	
	public static final String ESCAPE_BEGIN = "[";
	public static final String ESCAPE_END = "]";
	
	
	/**
	 * stores a request mapping pattern and corresponding variable
	 * configuration.
	 */
	@SuppressWarnings("rawtypes")
	protected static class PatternVariant {

		private final String pattern;
		
		private Map variables;

		public Map getVariables() {
			return variables;
		}

		public PatternVariant(String pattern) {
			super();
			this.pattern = pattern;
		}

		@SuppressWarnings({ "unchecked" })
		public PatternVariant(PatternVariant parent, int startPos, int endPos, boolean include) {
			final String p = parent.getPattern();
			final String varName = p.substring(startPos + 1, endPos);
			this.pattern = p.substring(0, startPos) + (include ? varName : "") + p.substring(endPos + 1);

			this.variables = new HashMap();
			if (parent.getVariables() != null) {
				this.variables.putAll(parent.getVariables());
			}
			this.variables.put(varName, Boolean.toString(include));
		}

		public String getPattern() {
			return pattern;
		}
	}

	/**
	 * here we use {@link AntPathMatcher#doMatch(String, String, boolean, Map)}
	 * to do the real match against the
	 * {@link #getPatternVariants(PatternVariant) calculated patters}. If
	 * needed, template variables are set.
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected boolean doMatch(String pattern, String path, boolean fullMatch,
			Map<String, String> uriTemplateVariables) {
		
		for (PatternVariant patternVariant : getPatternVariants(new PatternVariant(pattern))) {
			if (super.doMatch(patternVariant.getPattern(), path, fullMatch, uriTemplateVariables)) {
				if (uriTemplateVariables != null && patternVariant.getVariables() != null) {
					uriTemplateVariables.putAll(patternVariant.getVariables());
				}
				return true;
			}
		}

		return false;
	}
	
	
	/**
	 * build recursicly all possible request pattern for the given request
	 * pattern. For pattern: /houses/[preview/][small/]{id}, it
	 * generates all combinations: /houses/preview/small/{id},
	 * /houses/preview/{id} /houses/small/{id}
	 * /houses/{id}
	 */
	protected PatternVariant[] getPatternVariants(PatternVariant variant) {
		final String pattern = variant.getPattern();
		if (!pattern.contains(ESCAPE_BEGIN)) {
			return new PatternVariant[] { variant };
		} else {
			int startPos = pattern.indexOf(ESCAPE_BEGIN);
			int endPos = pattern.indexOf(ESCAPE_END, startPos + 1);
			PatternVariant[] withOptionalParam = getPatternVariants(new PatternVariant(variant, startPos, endPos, true));
			PatternVariant[] withOutOptionalParam = getPatternVariants(new PatternVariant(variant, startPos, endPos, false));
			return concat(withOptionalParam, withOutOptionalParam);
		}
	}
	
	
	
	/**
	 * utility function for array concatenation
	 */
	private static PatternVariant[] concat(PatternVariant[] A, PatternVariant[] B) {
		PatternVariant[] C = new PatternVariant[A.length + B.length];
		System.arraycopy(A, 0, C, 0, A.length);
		System.arraycopy(B, 0, C, A.length, B.length);
		return C;
	}
	
	
	

}
