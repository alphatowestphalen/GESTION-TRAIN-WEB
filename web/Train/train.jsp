<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../index/header.jsp" />

<div class="container-fluid ">
    <div class="row">
        <jsp:include page="../index/navebar.jsp" />
        <main class="col-md-10 bg-light border rounded-3 ">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3">
                <h1 class="h2">Train</h1>
                <input class="form-control form-control-white h-25 w-50" type="text" placeholder="Search" aria-label="Search">
                <div class="btn-toolbar mb-2 mb-md-0">
                    <a href="/train/login">
                        <button type="button" id="train" class="btn btn-outline-primary btn-sm" data-toggle="modal">
                            Ajouter Train
                        </button>
                    </a>
                </div>
            </div>

            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th scope="col">Numero Train</th>
                        <th scope="col">Nombre de Place</th>
                        <th scope="col">Desingation</th>
                        <th scope="col">Numero itineraire</th>
                        <th class="action" scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="train" items="${listeTrain}">
                        <tr>
                            <td><c:out value="${train.numTrain}" /></td>
                            <td><c:out value="${train.nbrPlace}" /></td>
                            <td><c:out value="${train.desing}" /></td>
                            <td><c:out value="${train.numItineraire}" /></td>
                            <td class="action">
                                <button type="button" class="btn btn-info btn-sm">edit</button>
                                <button type="button" class="btn btn-danger btn-sm">supprimer</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>
    </div>
</div>

</body>
</html>

