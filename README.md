# Shopify

## Routes
|Endpoint                    |GET|POST|PUT|DELETE|
|----------------------------|-----------|-----------|----------|------|
| /items/get/all             | Query all inventory items from the database.|-|-|-
| /items/get/1               | Query a product with Id of 1.|-|-|
| /items/insert   |-| Add a new product to the database. The request should look like this: `{"item_id":"2","item_name":"Item2","item_description":"Item2 description"}`|-|-
| /api/cart/1                | Query all data about a cart with Id of 1. That means all products added to the cart, their prices, quantities and total price.| Create a new cart with Id of 1 (if doesn't exist) and add a specified product to it. Example request: `{'product_id': 1, 'quantity': 2}`|-|Remove specific product from the cart.
| /api/cart/1/complete       |-|"Complete" the cart with Id of 1. This means that the inventory of each added product will be reduced.|-|-
