<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Base64"%>
<html>
<head>
<title>edit from</title>

<!-- bootstrap CDN link to get the support of bootstrap -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!--this is java script validation code location-->
<script type="text/javascript" src="formvalidation.js"></script>
</head>
<body style="background-color: purple">
<div class="cantainer mt-5 text-center">
		<h2 class="text-center font-italic mb-1">Save Product Data...</h2>
		<form method="post" action="./UpdateProductServlet" enctype="multipart/form-data" onsubmit="return validationForm()">
		
			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proId">Product ID:</label>
				<input type="text" class="form-control-sm" id="proId" name="proId" value="${existingproduct.proId}" required>
			</div>
			
			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proName">Product Name:</label>
				<input type="text" class="form-control-sm" id="proName" name="proName" value="${existingproduct.proName}" required>
			</div>
			
			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proPrice">Product Price</label>
				<input type="number" class="form-control-sm" id="proPrice" name="proPrice"  value="${existingproduct.proPrice}" required>
			</div>
			
			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proBrand">Product Brand:</label>
				<input type="text" class="form-control-sm" id="proBrand" name="proBrand" value="${existingproduct.proBrand}" required>
			</div>
			
			<div class="form-group">
				<label class="font-italic font-weight-bold" for="MadeIN">MadeIN:</label>
				<input type="text" class="form-control-sm" id="proMadeIn" name="proMadeIn" value="${existingproduct.proMadeIn}" required>
			</div>
			
			<div class="form-group">
				<label class="font-italic font-weight-bold" for="mfgdate">MfgDate:</label>
				<input type="date" class="form-control-sm" id="proMfgDate" name="proMfgDate" value="${existingproduct.proMfgDate}" required>
			</div>
			
			<div class="form-group">
				<label class="font-italic font-weight-bold" for="expdate">ExpDate:</label>
				<input type="date" class="form-control-sm" id="proExpDate" name="proExpDate" value="${existingproduct.proExpDate}" required>
			</div>
			
			<!-- display the current product image -->
			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proimage">current proImage:</label>
				 <img id="currentimage" src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(existingproduct.proImage)}" 
				 alt="Product Image" style="max-width: 100px; max-height: 100px;">
				 <input type="hidden" id="existingImage" name="existingImage" 
				 value="${Base64.getEncoder().encodeToString(existingproduct.proImage)}"/>
			
			</div> 
			<!-- allow the user to upload a new  image -->
			
			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proimage">New product image</label>
				<input type="file" class="form-control-sm" id="newproImage" name="newproImage"  accept="image/*">
			</div> 
			
			
			<div>
				<input type="submit" class="btn btn-success" value="update"/>
			</div>
			
		</form>
	</div>

</body>
</html>