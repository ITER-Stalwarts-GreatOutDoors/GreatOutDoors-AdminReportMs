Feature: Add Product Feature

  #This is how background can be used to eliminate duplicate steps
  Background: User navigates to Great Outdoors All Products Page
    Given I am on Add Product Form in Great Outdoors Product page

  Scenario Outline: User enters a valid Product Id, Product Name, Product Brand, Product Dimension, Product Specification, Quantity, Price, Category, Colour and Submits the form
    When I enter product id as "<productId>"
    And I enter product name as "<productName>"
    And I enter product brand as "<productBrand>"
    And I enter product dimension as "<productDimension>"
    And I enter product Specification as "<productSpecification>"
    And I enter quantity as "<productQuantity>"
    And I enter price as "<productPrice>"
    And I  select Category as "<category>"
    And I enter color as "<productColor>"
    And I click on submit button
    Then "<productId>" and "<productName>" Add Product Success Message Popped Up

    Examples: 
      | productId | productName | productBrand | productDimension | productSpecification | productQuantity | productPrice | category | productColor |
      | prod256   | Gloves      | Adidas       | Xl               | leather              |               2 |          200 | Golf     |       336699 |
      | prod258   | Jeans       | Levis        | 32 waist         | denim                |               1 |          300 | personal |       226699 |

  Scenario Outline: User enters a valid Product Id, Product Name, Product Brand, Product Dimension, Product Specification, Quantity, Price, Category, Colour and Submits the form
    When I enter product id as "<productId>"
    And I enter product name as "<productName>"
    And I enter product brand as "<productBrand>"
    And I enter product dimension as "<productDimension>"
    And I enter product Specification as "<productSpecification>"
    And I enter quantity as "<productQuantity>"
    And I enter price as "<productPrice>"
    And I  select Category as "<category>"
    And I enter color as "<productColor>"
    And I click on submit button
    Then Add Product Failure Message Popped Up

    Examples: 
      | productId | productName | productBrand | productDimension | productSpecification | productQuantity | productPrice | category | productColor |
      | prod07    | Gloves      | Adidas       | Xl               | leather              |               2 |          200 | Golf     |       336699 |
