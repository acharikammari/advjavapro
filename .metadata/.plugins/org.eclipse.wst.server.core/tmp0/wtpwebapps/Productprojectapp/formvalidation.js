function validationForm() {
    // Read the form data 
    var Id = document.getElementById("proId").value;
    var Name = document.getElementById("proName").value;
    var Price = document.getElementById("proPrice").value;
    var Brand = document.getElementById("proBrand").value;
    var Madein = document.getElementById("proMadeIn").value;
    
    if (Id.trim() === "" || Name.trim() === "" || Price.trim() === "" || Brand.trim() === "" 
    || Madein.trim() === "") {
        alert("All fields must be filled out.");
        return false;
    }
    
    if (parseFloat(proprice) < 0) {
        alert("Product price must be a non-negative value.");
        return false;    
    } 
    
    // Get the manufacturing & expiry dates
    var Mfgdate = document.getElementById("proMfgDate").value;
    var Expdate = document.getElementById("proExpDate").value;
    
      // Convert into date format
    var manufacturingDateObj = new Date(Mfgdate);
    var expiryDateObj = new Date(Expdate);
    
    // Check the validation of dates
    if (manufacturingDateObj > expiryDateObj) {
        alert("Manufacturing date cannot be greater than expiry date.");
        return false;
    }
    return true;
    }