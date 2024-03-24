function palindrome() {
    // Read the string stored in a variable
    const string = document.getElementById("String").value;
    
    // Check whether the string is a palindrome or not
    let reversed = "";
    for (let i = string.length - 1; i >= 0; i--) 
    {
        let ch = string.charAt(i);
        reversed = reversed + ch;
    }
    
    if (string === reversed) 
    {
        document.write("Given string is a palindrome");
    } else 
    {
        document.write("Given string is not a palindrome");
    }
}