# Shopify

## Routes
|Endpoint                    |GET|POST|PUT|DELETE|
|----------------------------|-----------|-----------|----------|------|
| /items/get/all             | Query all inventory items from the database.| Add a new product to the database. The request should look like this: `{'title': 'Product's title, 'price': 399.99, 'quantity': 10}`|-|Delete all existing products from the database.
| /items/get/1               | Query a product with Id of 1.|-|Update the product's details. The request should look like the POST request to create a new product except non of the fields are required. E.g you can update price only: `{'price': 459.86}`|Delete the product with an Id of 1.
| /api/products/1/purchase   |-| Purchase a product with Id of 1. `inventory_count` will be decresed in the database. If a product is unavailable you will get 404 `Product out of stock` response.|-|-
| /api/cart/1                | Query all data about a cart with Id of 1. That means all products added to the cart, their prices, quantities and total price.| Create a new cart with Id of 1 (if doesn't exist) and add a specified product to it. Example request: `{'product_id': 1, 'quantity': 2}`|-|Remove specific product from the cart.
| /api/cart/1/complete       |-|"Complete" the cart with Id of 1. This means that the inventory of each added product will be reduced.|-|-
