<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Hello, world!</title>
	
	
	<style>
		.head1 {
			width : 100%;
			height : 3%;
		}
		
		.head1 .topics1  {
			position : absolute;
			float : right;
			border : 1px solid black;
			width : 100%;
		}
		.head1  h3 {
			float:right;
		}
		.head1 a {
			margin-top : -3%;
			float : right; 
		}
		.m-t-25 {
		 margin-top: 25px;
		}
	</style>
  </head>
  <body>
    
	<!-- header section for professor page start-->
		<div class="head1 m-t-25">
			
			<div class="row">
				<div class="col-md-3 col-sm-3">
					<h4>Welcome user</h4>
				</div>
				<div class="col-md-2 col-sm-2">
				<!-- Going to Addquestion.html to add the questions -->
				<form action="Addquestion.html" method="get">
					<button type="submit" class="card-title" name="add">Add</button>
					<p class="card-text">Some quick example </p>
					</form>	
				</div>
				
				<div class="col-md-2 col-sm-2">
				<!-- Going to Updatequestion.java for updating the questions for the selected topic -->
					<a href="updatequestion">Update Question	&nbsp;</a>
				</div>
				
				<div class="col-md-2 col-sm-2">
				<!-- Going to Deleteques.java for deleting the questions for the selected topic -->
					<a href="deletequestion">Delete Question	&nbsp;</a>
				</div>
			<!-- going to StudentQuesHis.java to display all questions for the particular userid -->
				<div class="col-md-3 col-sm-3">
					<a href="questionhistory3"><h3>Questions History</h3></a>
				</div>
				
				
				
			
				
			</div>
			
		</div>
	
	
	
	<!-- header section for professor page end -->
	
	
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>