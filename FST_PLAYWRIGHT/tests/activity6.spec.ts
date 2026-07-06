import {test, expect} from '@playwright/test';

test.beforeEach(async ({page}) => {
    //open the test page 
    await page.goto("https://training-support.net/webelements/tabs");
    //assert the title of the page
    await expect(page).toHaveTitle("Selenium: Tab Opener");
});

test("Handling multiple tabs", async ({context, page}) =>{
    //event handler for new page
    const newPagePromise = context.waitForEvent('page');

    //click the button to open a new tab
    await page.getByRole('button', {name: 'Open a New Tab'}).click();

    //wait for the new page to open
    const newPage = await newPagePromise;
    await newPage.waitForEvent('load');

    //print the code on the new page 
    let word  = newPage.locator("span.fond-bold");
    console.log(await word.textContent());
    //Assertion
    expect(word).toBeVisible();

    //click the button to open another page
    await page.getByRole('button', {name: 'Open Another One'}).click();
})