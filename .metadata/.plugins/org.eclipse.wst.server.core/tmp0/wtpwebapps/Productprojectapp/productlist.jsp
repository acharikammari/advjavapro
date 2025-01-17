<%@page import="com.sathya.selvlet.ProductDao" import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Product List</title>
    <!-- Bootstrap CDN link to get the support of bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body style="background-color: purple">
		<h1 class="text-center text-success mb-1">List of Available products...</h1>
	<div>
	<a href="add-product.html" class="btn btn-success">save products</a>
	</div>
	
	<div>
	<input type="text" placeholder="search"/>
	</div>
	
	<div>
		<c:if test="${count==1}">
		<h1 class="text-center text-success">Data inserted successfully</h1>
		</c:if>
	</div>
	
	<div>
		<c:if test="${Dcount==1}">
		<h1 class="text-center text-danger">Data Deleted successfully...</h1>
		</c:if>
	
	</div>
	
	<div>
		<c:if test="${Dcount==0}">
		<h1 class="text-center text-danger">Data Deleted fail</h1>
		</c:if>
	
	</div>
	
	<table class="table table-bordered table-striped">
        <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Brand</th>
                <th>Made In</th>
                <th>MfgDate</th>
                <th>ExpDate</th>
                <th>Image</th>
                <th>Audio</th>
                <th>Video</th>
                <th>Actions</th>
    </tr>
   		 </thead>
 		<tbody>
            <c:forEach var="product" items="<%=new ProductDao().findAll()%>">
                <tr>
                    <td>${product.proId}</td>
                    <td>${product.proName}</td>
                    <td>${product.proPrice}</td>
                    <td>${product.proBrand}</td>
                    <td>${product.proMadeIn}</td>
                    <td>${product.proMfgDate}</td>
                    <td>${product.proExpDate}</td>
                    <td>
						<img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}" alt="Product Image" style="max-width: 100px; max-height: 100px;">
        			</td>
        			
        			<td>
        			<audio controls>
						<source src="data:audio/mpeg;base64,${Base64.getEncoder().encodeToString(product.proAudio)}" type="audio/mpeg">
        			</audio>
        			</td>
        			
        			<td>
        			<video controls width="320"  height="240">
						<source src="data:video/mp4;base64,${Base64.getEncoder().encodeToString(product.proVideo)}" type="video/mp4">
        			</video>
        			</td>
        			
        		
        			
        		<td>
				<a class="btn btn-danger" href="./DeleteProductServlet?proId=${product.proId}" >Delete</a>

				<a class="btn btn-success" href="./EditProductServlet?proId=${product.proId}" >Edit</a>
	
				</td>
                </tr>
        </c:forEach>
       </tbody>
       </table>
       </body>
                    
</html>