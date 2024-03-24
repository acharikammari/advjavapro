function convertToRupees()
{
	//read the doller store in varible
	
	const doller=document.getElementById("Doller").value;
	
	//covert the doller to Rupees
	
	const rup=(parseFloat(doller)*82.905);
	
	//set the output to rupees
	
	document.getElementById("Rupees").value=rup.toFixed(2);
	
}