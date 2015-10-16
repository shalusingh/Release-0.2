create table customer (customerId bigint not null  , country varchar(255), email varchar(255) not null, extraField1 varchar(255), extraField2 varchar(255), extraField3 varchar(255), landLineNumber varchar(15), lastLogin datetime, mobileNumber varchar(12) not null, name varchar(255) not null, organization varchar(255), password varchar(255) not null, phoneNumber varchar(12), registrationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null, secondaryEmail varchar(255), status integer not null, primary key (customerId))
create table customeraddress (addressId bigint not null  , addressLine1 varchar(200), addressLine2 varchar(200), addressStatus integer, city varchar(100), extraField1 varchar(150), extraField2 varchar(200), isDeliveryAddress integer, isPrimaryAddrss integer, pinCode bigint, state varchar(100), customerId bigint, primary key (addressId))
create table customersocialnetworks (SOCIALNETWORKID bigint not null  , CUSTOMERID bigint, EXTRAFIELD1 varchar(150), EXTRAFIELD2 varchar(150), EXTRAFIELD3 varchar(150), SOCIALNETWORKNAME varchar(200), SOCIALNETWORKTOKEN varchar(300), primary key (SOCIALNETWORKID))
create table offer (id bigint not null  , code varchar(255) not null, creationTime datetime not null, extraField1 varchar(150), extraField2 varchar(150), extraField3 varchar(150), offerInCash integer, offerInPercent integer, offerName varchar(255) not null, offerType integer not null, validTo datetime not null, primary key (id))
create table orderitemdelivery (deliveryId bigint not null  , deliveredDate datetime not null, deliveryBy varchar(150) not null, deliveryCharge float not null, extraField1 varchar(150), extraField2 varchar(200), extraField3 varchar(200), orderDate datetime not null, orderItemId bigint not null, paymentMode varchar(255) not null, status integer not null, supplierId bigint not null, tackingNumber varchar(150) not null, primary key (deliveryId))
create table orderitems (OrderItemId bigint not null  , costPerUnit float not null, discountPerUnit float not null, extraField1 varchar(150), extraField2 varchar(150), extraField3 varchar(150), finalCost float not null, orderId bigint, productId bigint, quantity integer not null, tax float not null, totalCost float not null, totalDiscount float not null, primary key (OrderItemId))
create table orders (orderId bigint not null  , addressId bigint not null, amount float not null, cartId bigint not null, completionDate datetime, customerId bigint not null, description varchar(350), discount float not null, extraField1 varchar(150), extraField2 varchar(200), extraField3 varchar(150), orderDate datetime not null, status integer not null, statusDetails varchar(350), primary key (orderId))
create table payment (paymentId bigint not null  , customerId bigint, extraField1 varchar(150), extraField2 varchar(150), extraField3 varchar(150), finalCost float not null, ipAddress varchar(15) not null, mode varchar(100) not null, orderId bigint, paymentDate datetime not null, source varchar(100) not null, status integer not null, statusDescription varchar(150), totalDiscount float not null, transactionId varchar(100) not null, primary key (paymentId))
create table product (productId bigint not null  , productCode varchar(12) not null, productDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null, productPriority integer, productStatus integer not null, primary key (productId))
create table productcategory (categoryId bigint not null  , categoryName varchar(50), extraField1 varchar(150), priority integer, status integer not null, primary key (categoryId))
create table productproperty (id bigint not null  , priority integer, propertyName varchar(20) not null, propertyValue varchar(200) not null, productId bigint, primary key (id))
create table productpropertyname (propertyId bigint not null  , categoryId bigint, extraField1 varchar(150), extraField2 varchar(150), priority integer not null, propertName varchar(50) not null, status integer not null, primary key (propertyId))
create table productsubcategory (subCategoryId bigint not null  , categoryId bigint not null, categoryName varchar(50) not null, extraField1 varchar(150), priority integer not null, status integer not null, primary key (subCategoryId))
create table recntlyview (id bigint not null  , customerId bigint, productId bigint, primary key (id))
create table shoppingcart (cartId bigint not null  , cartDate datetime not null, customerId bigint not null, extraField1 varchar(150), extraField2 varchar(200), jSessionId varchar(150) not null, productId bigint not null, quantity integer not null, status integer not null, primary key (cartId))
create table supplier (supplierId bigint not null  , email varchar(50) not null, extraField1 varchar(150), extraField2 varchar(150), extraField3 varchar(150), extraField4 varchar(200), fax varchar(12), landLineNumber varchar(12), landLineNumber2 varchar(12) not null, logo varchar(50), mobileNumber varchar(12) not null, name varchar(150) not null, registrationDate datetime not null, registrationNumber varchar(50) not null, secondaryMobileNumber varchar(12) not null, supplierStatus integer not null, tinNumber varchar(20) not null, typeOfGods integer not null, url varchar(50), primary key (supplierId))
create table supplieraccountdetails (id bigint not null  , accountNumber bigint not null, bankCity varchar(150) not null, bankState varchar(150) not null, branchAddress varchar(250) not null, branchName varchar(150) not null, extraField1 varchar(150), extraField2 varchar(150), supplierId bigint not null, primary key (id))
create table supplieraddress (addressId bigint not null  , addressLine1 varchar(200), addressLine2 varchar(200), addressStatus integer, city varchar(100), extraField1 varchar(150), extraField2 varchar(200), pinCode bigint, state varchar(100), supplierId bigint, primary key (addressId))
create table user (username varchar(255) not null  , enabled integer, password varchar(255), primary key (username))
create table user_roles (userRoleId bigint not null  , role varchar(255), username varchar(255), primary key (userRoleId))
create table wishlist (id bigint not null  , customerId bigint, date datetime not null, productId bigint, status integer not null, primary key (id))
