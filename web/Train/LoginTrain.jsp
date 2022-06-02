<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="${pageContext.request.contextPath}/index/header.jsp"/>
<div class="container-fluid ">
    <div class="row">

        <jsp:include page="${pageContext.request.contextPath}/index/navebar.jsp"/>

        <main class="col-md-10 bg-light p-4 border rounded-3 ">
            <div class="container w-75">
                <form action="train" method="GET">
                       
                            <label for="text">Numero de Train</label>
                            <input readonly="readonly" type="text" name="numTrain" class="form-control form-control-sm" placeholder="Numero Train" value ="<c:out value='${numTrain}'/>" id="text">

                            <label for="text">Nombre de Place</label>
                            <input type="number" min="0" name="numPlace" class="form-control form-control-sm" placeholder="Numero Place" id="text1">

                            <label for="text">Designation</label>
                            <input type="text" name="Design" class="form-control form-control-sm" placeholder="Designation" id="text2">

                            <label for="text">Numero Itineraire</label>
                            <select name="numIti" class="form-control form-control-sm" id="sel1">
                                <c:forEach var="getNumItis" items="${getNumIti}">
                                    <option><c:out value="${getNumItis.numItineraire}" /></option>
                                </c:forEach>
                            </select>

                        <button type="submit" class="btn btn-info mt-3 btn-block">Envoyer</button>
                </form>

        </main>




<jsp:include page="${pageContext.request.contextPath}/index/footer.jsp"/>

