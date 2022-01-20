# Shopify

## Run jar file
We need Java(11 or above) installed on the system to run the jar file
### Linux/Mac

Copy startup.ksh, shopify.jar files to a folder in your local system.
Please modify the placeholder(<JAVA_HOME>)startup.ksh file to point to Java bin folder (Ex: /Library/Java/JavaVirtualMachines/jdk-11.0.11.jdk/Contents/Home/bin)
Run the startup.ksh (Command->  ./startup.ksh)
Web service should start up like below
![Screenshot 2022-01-19 at 11 54 14 PM](https://user-images.githubusercontent.com/91156130/150281727-7797b9c9-4607-4f08-a719-4a4e3961e9f7.png)

End points can be accessed at http://localhost:8080/ (Example : http://localhost:8080/items/get/all)

## End points
|Endpoint                    |GET|POST|PUT|DELETE|
|----------------------------|-------------|-----------|----------|------|
| /items/get/all             | Query all inventory items from the database|-|-|-
| /items/get/1               | Query an item with Id of 1|-|-|
| /items/insert   |-| Add a new product to the database. The request should look like this: `{"item_id":"2","item_name":"Item2","item_description":"Item2 description"}`|-|-
| /items/update                | | Update existing item in the database The request should look like this: `{"item_id":"2","item_name":"Item2","item_description":"Item2 new description"}`|-|
| /items/delete/1       |-||-|Deletes item with item_id 1|
/items/downloadCSV| Downloads csv file of all available items in the database|-|-|-|
