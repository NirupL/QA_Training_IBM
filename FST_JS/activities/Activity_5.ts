// 5. The Async Fetcher (Promises & Async/Await)
// ### The Goal: Simulate an API call.
// * Task: Create a function fetchData that returns a Promise. Use setTimeout to resolve it after 2 seconds with a dummy JSON object.
// * TS Task: Define a type for the response data so the compiler knows exactly what the "API" returns.

// Define the specific structure of our API response data
type ApiResponse = {
    id: number;
    status: string;
    payload: {
        message: string;
        version: string;
    };
};

// Simulate an API call that returns a Promise of ApiResponse
function fetchData(): Promise<ApiResponse> {
    return new Promise((resolve) => {
        setTimeout(() => {
            const dummyData: ApiResponse = {
                id: 101,
                status: "success",
                payload: {
                    message: "Data fetched successfully",
                    version: "2.4.0"
                }
            };
            resolve(dummyData);
        }, 2000);
    });
}

// Example execution loop using async/await
async function runFetcher() {
    console.log("Fetching data...");
    const data = await fetchData();
    console.log("Received data:", data);
}

runFetcher();