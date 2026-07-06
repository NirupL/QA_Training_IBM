import { test, expect } from '@playwright/test';

test('has title', async ({ page }) => {
    await page.goto('https://training-support.net/webelements/target-practice');
    console.log(await page.title());
    await expect(page).toHaveTitle("Selenium: Target Practice");

    //locate cyan button and print its text
    const cyan = await page.getByRole('button', { name: 'Cyan' }).textContent();
    console.log(cyan);
    //locate the 6th heading and print its classes
    const sixth = await page.getByRole('heading', { name: 'Heading #6' }).getAttribute("class");
    console.log(sixth);
    //locate the 5th header and print its color
    const color5 = await page.getByRole('heading', { name: 'Heading #5' });
    console.log(await color5.evaluate((heading) => {
        return window.getComputedStyle(heading).getPropertyValue("color");
    }));
    //locate the pink button and print its dimensions
    const pink = await page.getByRole('button', { name: 'Pink' }).boundingBox();
    console.log(pink);

});