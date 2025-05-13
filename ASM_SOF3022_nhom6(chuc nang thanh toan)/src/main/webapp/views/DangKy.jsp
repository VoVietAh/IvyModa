<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!doctype html>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
</head>

<body>
    <header>
        <!-- place navbar here -->
    </header>
    <main>

        <!doctype html>
        <html lang="en">

        <head>
            <title>Title</title>
            <!-- Required meta tags -->
            <meta charset="utf-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

            <!-- Bootstrap CSS v5.2.1 -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
                crossorigin="anonymous" />
        </head>

        <body>
            <header>
                <!-- place navbar here -->
            </header>
            <main>
                <form:form  action="/account/save2" method="post" modelAttribute="dangkyValidate" enctype="multipart/form-data" >
                    <div class="row">
                        <div class="col-3">
                            <div class="input-group flex-nowrap mb-2">
                                <input type="text" name="username" class="form-control" placeholder="Username"
                                    aria-label="Username" aria-describedby="addon-wrapping"  required>
                                <div class="invalid-feedback">
        								Vui lòng nhập password
      							</div>
                            </div>
                            <div class="input-group flex-nowrap mb-2">
                                <input type="password" name="password" class="form-control" placeholder="password"
                                    aria-label="password" aria-describedby="addon-wrapping" required>
                                    <div class="valid-feedback">
										Looking good
                                </div>
                                <div class="invalid-feedback">
        								Vui lòng nhập password
      							</div>
                            </div>
                            <div class="input-group mb-3">
                                <input type="file" name="photo_file" class="form-control" aria-label="file example" required>
                                <div class="invalid-feedback">
                                	Vui lòng chọn hình
                                </div>
                            </div>
                            <div class="input-group has-validation">
                            <span class="input-group-text" id="inputGroupPrepend3">@</span>
                                <input type="text" name="emaill" class="form-control" id="validationServerUsername" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
                                
                              </div>
                              <div class="form-check">
                                <input type="radio" class="form-check-input" id="validationFormCheck2" name="radio-stacked" required>
                                <label class="form-check-label" for="validationFormCheck2">Male</label>
                              </div>
                              <div class="form-check mb-3">
                                <input type="radio" class="form-check-input" id="validationFormCheck3" name="radio-stacked" required>
                                <label class="form-check-label" for="validationFormCheck3">Female</label>
                                <div class="invalid-feedback">
                                	Vui lòng chọn giới tính
                                </div>
                              </div>
                            
                            <button type="submit" class="btn btn-primary">register</button>
                        </div>
                    </div>
                </form:form>
            </main>
            <footer>
                <!-- place footer here -->
            </footer>
            <!-- Bootstrap JavaScript Libraries -->
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
                crossorigin="anonymous"></script>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
                integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
                crossorigin="anonymous"></script>
        </body>

        </html>

    </main>
    <footer>
        <!-- place footer here -->
    </footer>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
</body>

</html>