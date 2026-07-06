import {test, expect} from '@playwright/test';

test.beforeEach(async ({page}) => {
    //open the test page
    await page.goto("https://training-support.net/webelements/alerts");
    //Assert the title of the page
    await expect(page).toHaveTitle("Selenium: Alerts");
});

//create a test function
test('Handling alerts with accept', async({page}) =>{
    //handler for the alert dialog
    page.on('dialog', async dialog => {
        //print the message from the console
        console.log(dialog.message());

        //handle the alert by clicking ok
        await dialog.accept();
    });

    //press the button to open an alert
    await page.getByRole('button', {name: "Simple"}).click();

    //assert the message
    let message = await page.getByTestId('result').textContent();
    expect(message).toBe('You just accepted a simple alert!');
});

test('Handling alerts with dismiss', async({page}) =>{
    //handler for the alert dialog
    page.on('dialog', async dialog => {
        //print the message from the console
        console.log(dialog.message());

        //handle the alert by clicking ok
        await dialog.dismiss();
    });

    //press the button to open an alert
    await page.getByRole('button', {name: "Confirmation"}).click();

    //assert the message
    let message = await page.getByTestId('result').textContent();
    expect(message).toBe('You just dismissed a confirmation alert!');
});

test('Handling prompt alerts', async({page}) =>{
    //handler for the alert dialog
    page.on('dialog', async dialog => {
        //print the message from the console
        console.log(dialog.message());

        //handle the alert by clicking ok
        await dialog.accept("Test message");
    });

    //press the button to open an alert
    await page.getByRole('button', {name: "Prompt"}).click();

    //assert the message
    let message = await page.getByTestId('result').textContent();
    expect(message).toBe('You typed "Test message" into the prompt!');
});

// // Write a handler for the alert
// page.on('dialog', async dialog => {
//   // To get the message fron the dialog
//   console.log(dialog.message());
//   switch(dialog.type()) {
//     case "alert":
//       // Click OK
//       dialog.accept();
//     case "confirm":
//       // Click Cancel
//       dialog.dismiss();
//     case "prompt":
//       // Accept with text
//       dialog.accept("Test String");
//   }
// });

// // Trigger the alert
// await page.evaluate(() => alert('1'));