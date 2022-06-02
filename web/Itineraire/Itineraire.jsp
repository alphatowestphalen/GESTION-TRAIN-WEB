<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../index/header.jsp" />

<div class="container-fluid ">
    <div class="row">
        <jsp:include page="../index/navebar.jsp" />
        <main class="col-md-10 bg-light border rounded-3 0342925166">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3">
                <h1 class="h2">Itineraire</h1>
                <input class="form-control form-control-white h-25 w-50" type="text" placeholder="Search" aria-label="Search">
                <div class="btn-toolbar mb-2 mb-md-0">
                    <a href="/Itineraire/login">
                        <button type="button" id="ajouter1" class="btn btn-outline-primary btn-sm" data-toggle="modal">
                            Ajouter Itineraire
                        </button>
                    </a>
                </div>
            </div>

            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th scope="col">Numero Itineraire</th>
                        <th scope="col">Ville de Depart</th>
                        <th scope="col">Ville d' Arriver</th>
                        <th scope="col">Frais de Transport(Ar)</th>
                        <th class="action text-center" scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="iti" items="${listeItineraire}">
                        <tr>
                            <td><c:out value="${iti.numItineraire}" /></td>
                            <td><c:out value="${iti.villeDepart}" /></td>
                            <td><c:out value="${iti.villeArrive}" /></td>
                            <td><c:out value="${iti.frais}" /></td>
                            <td class="action">
                                <a href="${pageContext.request.contextPath}/Itineraire/edit?Iti=<c:out value='${iti.id}' />"><button type="button" class="btn btn-info btn-sm">edit</button></a>
                                <a href="${pageContext.request.contextPath}/Itineraire/delet?Iti=<c:out value='${iti.id}' />"><button type="button" class="btn btn-outline-danger btn-sm">supprimer</button></a>
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

