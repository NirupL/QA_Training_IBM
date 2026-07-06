import { test, expect } from '@playwright/test';

test('has title', async ({ page }) => {
    await page.goto('https://training-support.net/webelements/simple-form');

    // await expect(page.getByRole('heading', { name: 'Simple Form' }));
    var title = await expect(page).toHaveTitle("Selenium: Simple Form");
    console.log(title);

});

test('fill form', async ({ page }) => {
    // Open the page
    await page.goto('https://training-support.net/webelements/simple-form');

    await page.getByRole('textbox', { name: 'Full name' }).fill("nirup");

    await page.getByRole('textbox', { name: 'Email address' }).fill("abc@g.com");

    await page.getByTestId('event-date').fill("2026-06-23");

    await page.getByRole('textbox', { name: 'Additional Details' }).fill("nothing");

    await page.getByRole('button', { name: 'Submit' }).click();

    //verify the confirmation message
    await expect(page.getByRole('heading', { name: 'Your event has been scheduled!' })).toHaveText("Your event has been scheduled!")
    // console.log(`The result text is: ${await result_text.textContent()}`);
    // await expect(result_text.textContent()).toEqual("Your event has been scheduled!");
});