
function reverseOfString() {
    // Read the string stored in a variable
    const string = document.getElementById("String").value;
    
    // Reverse the string
    let reversed = "";
    for (let i = string.length-1;i>=0;i--) {
        let ch =string.charAt(i);
        reversed=reversed+ch;
    }
    
    // Set the output to reverseString
    document.getElementById("ReverseString").value = reversed;
}