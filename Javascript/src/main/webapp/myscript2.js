function convertToCelcius()
{
	//read the fahrenheitInput store in varible
	
	const fahrenheit=document.getElementById("farhenheitInput").value;
	
	//convert fahrenheit to celcius
	
	const celcius=(parseFloat(fahrenheit)-32)*5/9;
	
	// set the output to celciusoutput files
	
	document.getElementById("celciusoutput").value=celcius.toFixed(2);
}
