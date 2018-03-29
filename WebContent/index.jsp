<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
        <%@ page import="java.util.*" %>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

                <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
                <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
                <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.min.js"></script>

                <link rel="stylesheet" href="http://jqueryvalidation.org/files/demo/site-demos.css">
                <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">

                <title>Insert title here</title>

                <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
				
				<style type="text/css">
					*
					{
						box-sizing: border-box;
					}
				
					thead:HOVER {
						cursor: pointer;
					}
					
					#pages
					{
						position: absolute;
						left: 90px;
					}
					
					/* #clickName
					{
						color:red;
						background:url("img/aesc.jpg") right;
						background-size: 15px 15px;
						background-repeat: no-repeat;
					} */
				</style>
				
				<script type="text/javascript">
					var i=0;
					var val;
					$(document).ready(function(){
					    $("#clickName").click(function(){
					    	$(this).find('img').toggle();
					    	/* $("#clickName img.alt").hide();
    						$("#clickName img.orig").show();
					    	$("img", this).toggle(); */
					    	document.location.href = "sortName";
					    });
					    
					    $("#clickRollNo").click(function(){
					    	/* $(this).find('img').toggle(); */
					    	document.location.href = "sortRollNo";
					    });
					    
					    $("#clickCountry").click(function(){
					    	/* $(this).find('img').toggle(); */
					    	document.location.href = "sortCountry";
					    });
					    
					    $("#pages").change(function(){
					    	val = $("#pages").val();
					    	
					    	/* alert(val); */
					    	document.location.href = "pageVal?val="+val;
					    });
					});
				</script>
				
                <script type="text/javascript">
                    $(document).ready(function() { // <-- enclose your code in a DOM ready handler
                        $("#savelogin").validate({
                            errorElement: 'username',
                            rules: {

                                "sid": { // <-- assign by field name and use quotes
                                    required: true
                                },
                                "sname": {
                                    required: true, // <-- this rule was misspelled 'equired'
                                    minlength: 3,
                                    maxlength: 15
                                },
                                "scountry": {
                                    required: true,
                                    minlength: 3,
                                    maxlength: 15
                                }
                            },
                            messages: {
                                "sid": {
                                    required: "Id is required!"
                                },
                                "sname": {
                                    required: "User name is required",
                                    minlength: "Name must be at least 3 char to 15 long"
                                },
                                "scountry": {
                                    required: "Country name is required!",
                                    minlength: "Country name be at least 3 char to 15 long"
                                }
                            }
                        });

                        $("#updateMe").validate({
                            errorElement: 'username',
                            rules: {

                                "sid": { // <-- assign by field name and use quotes
                                    required: true
                                },
                                "sname": {
                                    required: true, // <-- this rule was misspelled 'equired'
                                    minlength: 3,
                                    maxlength: 15
                                },
                                "scountry": {
                                    required: true,
                                    minlength: 3,
                                    maxlength: 15
                                }
                            },
                            messages: {
                                "sid": {
                                    required: "Id is required!"
                                },
                                "sname": {
                                    required: "User name is required",
                                    minlength: "Name must be at least 3 char to 15 long"
                                },
                                "scountry": {
                                    required: "Country name is required!",
                                    minlength: "Country name be at least 3 char to 15 long"
                                }
                            }
                        });
                    });
                </script>

                <script type="text/javascript">
                    $(document).ready(function() {
                        $("#searchInput").keyup(function() {

                            // Retrieve the input field text and reset the count to zero
                            var filter = $(this).val(),
                                count = 0;

                            // Loop through the comment list
                            $("tr").each(function() {

                                // If the list item does not contain the text phrase fade it out
                                if ($(this).text().search(new RegExp(filter, "i")) < 0) {
                                    $(this).fadeOut();

                                    // Show the list item if the phrase matches and increase the count by 1
                                } else {
                                    $(this).show();
                                    count++;
                                }
                            });

                            // Update the count
                            var numberItems = count;
                            $("#filter-count").text("Number of Comments = " + count);
                        });
                    });
                </script>

                <script type="text/javascript">
                    function updateEmp(id, name, cnt) {
                        $("#update-dialog").dialog("open");
                        document.getElementById("tid").value = id;
                        document.getElementById("tid1").value = id;
                        document.getElementById("tname").value = name;
                        document.getElementById("tcountry").value = cnt;
                    }

                    function deleteEmp(did) {
                        var t = confirm("Are you want to delete id : " + did);
                        if (t == true) {
                            document.fom.action = "deleteMe.action?tid=" + did;
                            document.fom.submit();
                        } else {

                        }
                    }

                    function alertMe() {
                        alert("Hi.");
                    }

                    $(function() {
                        $("#dialog-1").dialog({
                            autoOpen: false,
                        });
                        $("#update-dialog").dialog({
                            autoOpen: false,
                        });
                        $("#opener").click(function() {
                            $("#dialog-1").dialog("open");
                        });
                    });
                </script>

            </head>

            <body>
                <div class="container">
                    <div id="dialog-1" title="Add Employee">
                        <form action="saveMe" id="savelogin" method="post">
                            <table align="center" class="table">
                                <tr class="row">
                                    <td class="col-sm-3">Roll no :</td>
                                    <td class="col-sm-4">
                                        <input type="text" name="sid" />
                                    </td>
                                </tr>
                                <tr class="row">
                                    <td class="col-sm-3">Name :</td>
                                    <td class="col-sm-4">
                                        <input type="text" name="sname" />
                                    </td>
                                </tr>
                                <tr class="row">
                                    <td class="col-sm-3">Country:</td>
                                    <td class="col-sm-4">
                                        <input type="text" name="scountry" />
                                    </td>
                                </tr>
                                <tr class="row">
                                    <td colspan="2" align="center" class="col-sm-7">
                                        <input type="submit" value="Add">
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                    <center>
                        <a href="dTag" >Display Tag</a> | 
                        <a href="dynamicText.jsp" >Dynamic text</a>
                        <br>
                        <br>
                        <br>
                        <div>
                            <h2>List of Employees</h2>
                       	</div>
                    </center>

                    <br>
                    <br>
                    <center>
                        <div id="opener">
                            <button>Add employee</button>
                        </div>
                    </center>
                    <br>

                    <div id="update-dialog" title="Update Employee">
                        <form action="updateMe" id="updateMe" method="post">
                            <table align="center" class="table">
                                <tr class="row">
                                    <td class="col-sm-3">Roll no :</td>
                                    <td class="col-sm-4">
                                        <input type="text" id="tid" disabled="true" />
                                        <input type="hidden" id="tid1" name="sid">
                                    </td>
                                </tr>
                                <tr class="row">
                                    <td class="col-sm-3">Name :</td>
                                    <td class="col-sm-4">
                                        <input type="text" id="tname" name="sname" />
                                    </td>
                                </tr>
                                <tr class="row">
                                    <td class="col-sm-3">Country:</td>
                                    <td class="col-sm-4">
                                        <input type="text" id="tcountry" name="scountry" />
                                    </td>
                                </tr>
                                <tr class="row">
                                    <td colspan="2" align="center" class="col-sm-7">
                                        <input type="submit" value="Update">
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>

                    <div class="container">

                        <center>
                        	
                            <div class="col-sm-5 form-group">
                            	<div class="col-sm-2">
                            	<select id="pages" class="form-control">
	                        		<option>10</option>
	                        		<option>25</option>
	                        		<option>50</option>
	                        		<option>100</option>
                        		</select>
                        		</div>
                            </div>
                            <div class="col-sm-2">
                                <input type="text" placeholder="Search here." class="searchInput form-control" id="searchInput" />
                            </div>
                            <div class="col-sm-5"></div>
                            <%-- <span id="filter-count"></span> --%>
                        </center>
						
						<br>
						<br>
						
                        <table align="center" class="table">
                            <form name="fom" method="post">
                                <thead>
                                	<tr class="row">
                                        <th class="col-sm-2"><input type="text" placeholder="Search Roll No" class="form-control"></th>
                                        <th class="col-sm-2"><input type="text" placeholder="Search Name" class="form-control"></th>
                                        <th class="col-sm-2"><input type="text" placeholder="Search Country" class="form-control"></th>
                                        <th class="col-sm-2"></th>
                                        <th class="col-sm-2"></th>
                                    </tr>
                                    <tr class="row">
                                        <th class="col-sm-2" id="clickRollNo">ROLL NO :</th>
                                        <th class="col-sm-2" id="clickName">NAME : <img src="img/aesc.jpg" class="orig" align="right" height="15px" width="15px"/> <img src="img/desc.jpg" class="alt" align="right" height="15px" width="15px" style="display:none"/></th>
                                        <th class="col-sm-2" id="clickCountry">COUNTRY :</th>
                                        <th class="col-sm-2">EDIT :</th>
                                        <th class="col-sm-2">DELETE :</th>
                                    </tr>
                                </thead>
                                <%
								List l=(List)request.getAttribute("disp");
								if(l!=null)
								{
									Iterator it=l.iterator();
									while(it.hasNext())
									{
										com.crud.bean b=(com.crud.bean)it.next();
										int tempNum = b.getNo();
										String tempName = b.getNam();
										String tempCountry = b.getCt();
										%>
					                    <tr class="row">
					                        <td class="col-sm-2">
					                            <%= tempNum %>
					                        </td>
					                        <td class="col-sm-2">
					                            <%= tempName %>
					                        </td>
					                        <td class="col-sm-2">
					                            <%= tempCountry %>
					                        </td>
					                        <td class="col-sm-2"><a href="#" onclick='updateEmp(<%= tempNum %>, "<%= tempName %>", "<%= tempCountry %>");'>Edit</a></td>
					                        <td class="col-sm-2" id="delMe"><a href="#" onclick='deleteEmp(<%= tempNum %>);'>Delete</a></td>
					                        <%System.out.println(tempNum); %>
					                    </tr>
					                    <%
									}
								}
								%>
                            </form>
                            
                        </table>
                        <center>
                        <a href="pagination?page=1">1</a>  
						<a href="pagination?page=2">2</a>  
						<a href="pagination?page=3">3</a>
						</center>
                    </div>
                </div>
            </body>

            </html>