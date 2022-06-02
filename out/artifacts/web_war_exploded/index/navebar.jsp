
<jsp:include page="header.jsp" />
    <nav id="sidebarMenu" class="col-md-2 w-25 bg-light border rounded-3">
        <h3>Dashboard</h3>
        <div class="position-sticky pt-3">
            <ul class="nav flex-column">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/">
                        <i class="fas fa-home"></i> Home
                    </a>
                </li>
                <li class="nav-item active train">
                    <a class="nav-link" href="/train">
                        <i class="fas fa-train"></i> Train
                    </a>
                </li>
                <li class="nav-item voyageur">
                    <a class="nav-link" href="/Itineraire">
                        <i class="fas fa-city"></i> Itineraire
                    </a>
                </li>
                <li class="nav-item reservation">
                    <a class="nav-link " href="/Reservation">
                        <i class="fas fa-list"></i> Reservation
                    </a>
                </li>
                <li class="nav-item voyageur">
                    <a class="nav-link" href="/Voyageur">
                        <i class="fas fa-user"></i> Voyageurs
                    </a>
                </li>

            </ul>
        </div>
    </nav>
<jsp:include page="footer.jsp"/>