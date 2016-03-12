/**
 *
 */
package com.onlinemarketplace.dataentity.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jitendra Dec 23, 2015 2015
 */
public enum Right {
    NONE(0, "NONE"), READ(1, "READ"), READ_RIGHT(2, "READ_RIGHT"), READ_RIGHT_UPDATE(3, "READ_RIGHT_UPDATE"), ALL(4,
        "ALL");
    public int id;
    public String value;

    private Right(int id, String value) {
        this.id = id;
        this.value = value;
    }

    private int getId() {
        return id;
    }

    private String getValue() {
        return value;
    }

    private static final Map<Integer, Right> byId = new HashMap<Integer, Right>();
    private static final Map<String, Right> byValue = new HashMap<String, Right>();

    static {
        for (Right e : Right.values()) {
            if (byId.put(e.getId(), e) != null) {
                throw new IllegalArgumentException("duplicate id: "
                    + e.getId());
            }

            if (byValue.put(e.getValue(), e) != null) {
                throw new IllegalArgumentException("duplicate value: "
                    + e.getValue());
            }
        }
    }

    public static Right getById(int id) {
        return byId.get(id);
    }

    public static Right getByValue(String value) {
        return byValue.get(value);
    }

}
