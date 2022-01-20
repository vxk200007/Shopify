# Shopify

## Routes
|Endpoint                    |GET|POST|PUT|DELETE|
|----------------------------|-----------|-----------|----------|------|
| /items/get/all             | Query all inventory items from the database|-|-|-
| /items/get/1               | Query an item with Id of 1|-|-|
| /items/insert   |-| Add a new product to the database. The request should look like this: `{"item_id":"2","item_name":"Item2","item_description":"Item2 description"}`|-|-
| /items/update                | | Update existing item in the database The request should look like this: `{"item_id":"2","item_name":"Item2","item_description":"Item2 new description"}`|-|
| /items/delete/1       |-||-|Deletes item with item_id 1
