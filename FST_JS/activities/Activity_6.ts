// 6. Script Sanitization
// ### The Goal
// Neutralize strings that could contain malicious code and prepare them for safe storage or display.
// ### Task
// * Create a utility function to sanitize raw user input that does the following:
//     * Trims leading/trailing whitespace.
//     * Escapes HTML special characters (preventing XSS).

// Function to sanitize user input by trimming whitespace and 
// escaping HTML special characters
function sanitizeInput(rawInput: string): string {
    // Step 1: Trim leading and trailing whitespace
    const trimmed = rawInput.trim();

    // Step 2: Escape HTML special characters to mitigate Cross-Site Scripting (XSS)
    return trimmed.replace(/[&<>"']/g, (char) => {
        switch (char) {
            case '&': return '&amp;';
            case '<': return '&lt;';
            case '>': return '&gt;';
            case '"': return '&quot;';
            case "'": return '&#39;';
            default: return char;
        }
    });
}

// Example usage:
const maliciousInput = "   <script>alert('hack');</script>   ";
const safeInput = sanitizeInput(maliciousInput);

console.log(safeInput);
// Output: "&lt;script&gt;alert(&#39;hack&#39;);&lt;/script&gt;"