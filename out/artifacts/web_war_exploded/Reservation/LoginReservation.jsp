<jsp:include page="${pageContext.request.contextPath}/index/header.jsp"/>
<div class="container-fluid ">
    <div class="row">

        <jsp:include page="${pageContext.request.contextPath}/index/navebar.jsp"/>

        <main class="col-md-10 bg-light p-4 border rounded-3 ">
            <div class="container w-75">
                <form action="Reservation" method="GET">
                    <div class="row">
                        <div class="col-sm-6">
                            <label>Numero Reservation</label>
                            <input type="text" name="numRes" class="form-control form-control-sm" placeholder="Numero Reservation">
                        </div>
                        <div class="col-sm-6">
                            <label>Numero Train</label>
                            <input type="text" name="numTrain" class="form-control form-control-sm" placeholder="Numero Train">
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-6">
                            <label >Numero Place</label>
                            <input type="text" name="numPlace" class="form-control form-control-sm" placeholder="Numero Place">
                        </div>
                        <div class="col-sm-6">
                            <label>Date de depart</label>
                            <input type="datetime-local" name="dateDep" class="form-control form-control-sm" placeholder="Date de depart">
                        </div>
                    </div>
                    <div class="">
                        <label>Nom voyageur</label>
                        <input type="text" name="nomVoy" class="form-control form-control-sm" placeholder="Nom voyageur">
                    </div>
                    <button type="submit" class="btn btn-info mt-3 btn-block">Envoyer</button>
                </form>
            </div>
        </main>

    </div>
</div>

<jsp:include page="${pageContext.request.contextPath}/index/footer.jsp"/>
