<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="${pageContext.request.contextPath}/index/header.jsp"/>
    <div class="container-fluid ">
        <div class="row">

            <jsp:include page="${pageContext.request.contextPath}/index/navebar.jsp"/>

            <main class="col-md-10 bg-light p-4 border rounded-3 ">
                <div class="container w-75">
                    <c:if test="${itineraire == null}">
                        <form action="/Itineraire/ajouter" method="POST">
                    </c:if>
                        <c:if test="${itineraire != null}">
                        <form action="/Itineraire/update" method="POST">
                    </c:if>
                    <c:if test="${itineraire != null}">
                            <input hidden type="text" name="id" value="<c:out value='${itineraire.id}'/>">
                    </c:if>
                        <div class="">
                            <label>Numero Itineraire</label>
                            <input readonly="readonly" type="text" name="numIti" <c:if test="${itineraire != null}"> value="<c:out value='${itineraire.numItineraire}'/>" </c:if> <c:if test="${itineraire == null}"> value="<c:out value='${numItineraire.numItineraire}'/>" </c:if>  class="form-control form-control-sm" placeholder="Numero Itineraire">
                        </div>
                        <div class="">
                            <label >Ville de Depart</label>
                            <input type="text" name="villeDep" value="<c:out value='${itineraire.villeDepart}'/>" class="form-control form-control-sm" placeholder="Ville de depart">
                        </div>
                        <div class="">
                            <label>Ville d'Arriver</label>
                            <input type="text" name="villeArr" value="<c:out value='${itineraire.villeArrive}'/>" class="form-control form-control-sm" placeholder="Ville d' Arriver">
                        </div>
                        <div class="">
                            <label>Frais</label>
                            <input type="text" name="Frais" value="<c:out value='${itineraire.frais}'/>" class="form-control form-control-sm" placeholder="Frais">
                        </div>
                        <c:if test="${itineraire == null}">
                        <button type="submit" class="btn btn-info mt-3 btn-block">Envoyer</button>
                        </c:if>
                        <c:if test="${itineraire != null}">
                        <button type="submit" class="btn btn-info mt-3 btn-block">Modifier</button>
                        </c:if>
                    </form>
                </div>
            </main>

        </div>
    </div>

<jsp:include page="${pageContext.request.contextPath}/index/footer.jsp"/>
