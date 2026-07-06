import {test, expect} from '@playwright/test';

test.beforeEach(async ({page}) => {
    //Open the page
    await page.goto("/inventory.html");
    //Assert the title of the page
    await expect(page.getByText("Products")).toBeVisible();
});

test("login and logout test", async ({page}) => {
    //open the menu button
    await page.getByRole('button', {name: 'Open Menu'}).click();
    //click the logout after that
    await page.getByRole('link', {name: 'Logout'}).click();

    //verify the login page agin
    await expect(page.locator('[data-test="login-button"]')).toBeVisible();
});

test('product detail page', async({page}) => {
    //click on the 4th item of the products page
    await page.locator('[data-test="item-5-img-link"]').click();
    //verify the product details
    await expect(page.locator('[data-test="inventory-item-name"]')).toHaveText('Sauce Labs Fleece Jacket');
    await expect(page.locator('[data-test="inventory-item-price"]')).toHaveText('$49.99');
    await expect(page.locator('[data-test="item-sauce-labs-fleece-jacket-img"]')).toBeVisible();

    //click on back to products to go back
    await page.locator('[data-test="back-to-products"]').click();

    //click on another product and do the same
    await page.locator('[data-test="item-4-img-link"]').click();
    //verify the product details
    await expect(page.locator('[data-test="inventory-item-name"]')).toHaveText('Sauce Labs Backpack');
    await expect(page.locator('[data-test="inventory-item-price"]')).toHaveText('$29.99');
    await expect(page.locator('[data-test="item-sauce-labs-backpack-img"]')).toBeVisible();

});

test('Full checkout flow', async({page}) => {
    //add some products to the cart
    await page.locator('[data-test="add-to-cart-sauce-labs-backpack"]').click();
    await page.locator('[data-test="add-to-cart-sauce-labs-bike-light"]').click();

    //open the cart and verify the items
    await page.locator('[data-test="shopping-cart-link"]').click();
    await expect(page.locator('[data-test="item-4-title-link"]')).toBeVisible();
    await expect(page.locator('[data-test="item-0-title-link"]')).toBeVisible();

    //click on the checkout button
    await page.getByRole('button', {name: 'Checkout'}).click();

    //enter the customer details
    await page.locator('[data-test="firstName"]').fill("Thor");
    await page.locator('[data-test="lastName"]').fill("Ragnarok");
    await page.locator('[data-test="postalCode"]').fill("560064");

    //click the continue button
    await page.locator('[data-test="continue"]').click();

    //verify the total cost
    await expect(page.locator('[data-test="total-label"]')).toContainText("Total");
    //click on the finish button
    await page.getByRole('button', {name: 'Finish'}).click();

    //verify the success message
    await expect(page.locator('[data-test="complete-header"]')).toHaveText("Thank you for your order!");

});

