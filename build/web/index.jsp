<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Title</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
            integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <!-- Bootstrap CSS -->
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
            />
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">
                    <img
                        src="https://png.pngtree.com/template/20190422/ourmid/pngtree-phone-store-logo-design-image_145177.jpg"
                        width="50"
                        /></a>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <form class="form-inline mr-auto">
                        <input
                            class="form-control mr-sm-2"
                            type="search"
                            placeholder="Search"
                            aria-label="Search"
                            />
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
                            Search
                        </button>
                    </form>
                    <ul class="navbar-nav my-2 my-lg-0">
                        <li class="ml-3">
                            <button type="button" class="btn btn-primary" data-toggle="modal"
                                    data-target="#exampleModal2"
                                    data-whatever="@getbootstrap" >
                                <i class="fas fa-plus"></i> Add Product
                            </button>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Product Name</th>
                    <th scope="col">
                        <button type="button" class="btn btn-light">
                            <i class="fas fa-sort"></i>
                        </button>
                    </th>
                    <th scope="col">Price</th>
                    <th scope="col">Creation Date</th>
                    <th scope="col">Category</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td scope="row">P-1</td>
                    <td>Samsung Galaxy1</td>
                    <td>
                        <img
                            src="https://cdn.tgdd.vn/Products/Images/42/226935/samsung-galaxy-z-fold-3-silver-1-600x600.jpg"
                            width="100"
                            />
                    </td>
                    <td>37990000 đ</td>
                    <td>15-04-2022</td>
                    <td>Samsung</td>
                    <td>
                        <button type="button" class="btn btn-primary">
                            <i class="fas fa-edit"></i> Edit
                        </button>
                    </td>
                    <td>
                        <button
                            type="button"
                            class="btn btn-warning"
                            data-toggle="modal"
                            data-target="#exampleModal"
                            >
                            <i class="fas fa-info"></i> Detail
                        </button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-danger">
                            <i class="fa fa-trash"></i> Delete
                        </button>
                    </td>
                </tr>
            </tbody>
        </table>
        <footer>
            <div>
                <h2>Choose feature</h2>
                <form method="post" action="MainController">
                    <input type="submit" name="btnAction" value="Generate Data" />
                    <input type="submit" name="btnAction" value="Crawl Data" />
                    <input type="submit" name="btnAction" value="Check Data" />
                </form>
                <h2>
                    <font color="green">
                    ${requestScope.SUCCESS}
                    </font>
                    <font color="green">
                    ${requestScope.SUCCESS_CREATE}
                    </font>
                </h2>
                <c:if test="${requestScope.SUCCESS_CREATE ne null }">
                    <p>Click on the image to download it:<p>
                        <a href="MainController?btnAction=Dowload Data" download="fileXML">
                            <img src="https://www.phoca.cz/images/projects/phoca-download-r.png" width="100" height="100">
                        </a>
                    </c:if>
            </div>
        </footer>

        <div
            class="modal fade"
            id="exampleModal2"
            tabindex="-1"
            aria-labelledby="exampleModalLabel"
            aria-hidden="true"
            >
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Create Product</h5>
                        <button
                            type="button"
                            class="close"
                            data-dismiss="modal"
                            aria-label="Close"
                            >
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label"
                                       >Name Product:</label
                                >
                                <input type="text" class="form-control" id="recipient-name" />
                            </div>
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label"
                                       >Price:</label
                                >
                                <input type="text" class="form-control" id="recipient-name" />
                            </div>
                            <div class="form-group nav-item dropdown">
                                <label for="recipient-name" class="col-form-label"
                                       >Category:</label
                                >
                                <select
                                    name="cars"
                                    id="cars"
                                    class="nav-link dropdown-toggle"
                                    href="#"
                                    id="navbarDropdown"
                                    role="button"
                                    data-toggle="dropdown"
                                    aria-expanded="false"
                                    >
                                    <option class="dropdown-item" value="volvo">Samsung</option>
                                    <option class="dropdown-item" value="saab">iPhone</option>
                                    <option class="dropdown-item" value="saab">OPPO</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label"
                                       >Image:</label
                                >
                                <input type="file" class="form-control" name="newImage" />
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button
                            type="button"
                            class="btn btn-secondary"
                            data-dismiss="modal"
                            >
                            Close
                        </button>
                        <button type="button" class="btn btn-primary">Add Product</button>
                    </div>
                </div>
            </div>
        </div>

        <div
            class="modal fade"
            id="exampleModal"
            tabindex="-1"
            role="dialog"
            aria-labelledby="exampleModalLabel"
            aria-hidden="true"
            >
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">
                            Detailed Product Description
                        </h5>
                        <button
                            type="button"
                            class="close"
                            data-dismiss="modal"
                            aria-label="Close"
                            >
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Provident
                        non atque nulla nobis. Delectus molestias hic accusamus!
                        Reprehenderit quaerat ut voluptatem? Modi dolorem a perferendis
                        rerum optio impedit quasi doloremque autem perspiciatis esse qui
                        quam maxime minima quos libero veniam tempora, voluptate praesentium
                        iure dignissimos, explicabo illo omnis earum harum.
                    </div>
                    <div class="modal-footer">
                        <button
                            type="button"
                            class="btn btn-secondary"
                            data-dismiss="modal"
                            >
                            Close
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script
            src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://kit.fontawesome.com/a076d05399.js"
            crossorigin="anonymous"
        ></script>
    </body>
</html>

