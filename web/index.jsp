<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css"
            />
        <link
            href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css"
            />
        <link rel="stylesheet" href="./dataTable.css" />
    </head>
    <body>
        <div>            
            <header>
                <nav class="navbar navbar-light bg-light">
                    <a class="navbar-brand" href="#">
                        <img
                            src="https://png.pngtree.com/template/20190422/ourmid/pngtree-phone-store-logo-design-image_145177.jpg"
                            width="50"
                            /></a>
                    <form class="form-inline">
                        <button type="button" class="btn btn-primary" data-toggle="modal"
                                data-target="#exampleModal2"
                                data-whatever="@getbootstrap" >
                            <i class="fas fa-plus"></i> Add Product
                        </button>
                    </form>
                </nav>
            </header>
            <div style="width: 98%; margin: auto">
                <div>
                    <form method="post" action="MainController">
                        <input type="submit" name="btnAction" value="Generate Data" />
                        <input type="submit" name="btnAction" value="Crawl Data" />
                        <input type="submit" name="btnAction" value="Check Data" />
                        <input type="submit" name="btnAction" value="Load Data" />
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
                <table id="dataTable"
                       class="table table-striped table-bordered"
                       style="width: 100%">
                    <thead>
                        <tr>
                            <th style="width: 100px">Id <i class="fas fa-sort"></i></th>
                            <th style="width: 200px">Product Name <i class="fas fa-sort"></i></th>
                            <th></th>
                            <th>Price <i class="fas fa-sort"></i></th>
                            <th>Creation Date</th>
                            <th>Category</th>
                            <th></th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="list" items="${sessionScope.LISTPRODUCTS}" varStatus="counters">
                            <tr>
                                <td>${list.productId}</td>
                                <td>${list.productName}</td>
                                <td>
                                    <img
                                        src="${list.image}"
                                        width="100"
                                        />
                                </td>  
                                <td>
                                    <fmt:setLocale value = "vi_VN"/>
                                    <fmt:formatNumber value = "${list.price}" type = "currency"/>
                                </td>
                                <td>${list.creationDate}</td>
                                <td>
                                    <c:if test="${list.categoryId eq 'C-1'}">
                                        Samsung
                                    </c:if>
                                    <c:if test="${list.categoryId eq 'C-2'}">
                                        iPhone
                                    </c:if>
                                    <c:if test="${list.categoryId eq 'C-3'}">
                                        OPPO
                                    </c:if>
                                </td>
                                <td>
                                    <button type="button" class="btn btn-primary" data-toggle="modal"
                                            data-target="#exampleModal2"
                                            data-whatever="@getbootstrap" >
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
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <footer>
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
            <script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
            <script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
            <script src="./dataTable.js"></script>
    </body>
</html>

