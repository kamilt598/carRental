<%@include file="dynamic/header.jspf"%>

    <section class="hero-wrap hero-wrap-2 js-fullheight" style="background-image: url('/resources/images/bg_3.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-end justify-content-start">
          <div class="col-md-9 ftco-animate pb-5">
          	<p class="breadcrumbs"><span class="mr-2"><a href="home.jsp">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Cars <i class="ion-ios-arrow-forward"></i></span></p>
            <h1 class="mb-3 bread">Choose Your Car</h1>
         </div>
      </div>
   </div>
</section>
<section class="ftco-section bg-light">
      <input type="hidden" id="carId" name="carId">
      <br>
      <div class="container">
         <a href='<c:url value="/"/>' class="nav-link">&#8592; Back</a>
         <div class="row">
            <d:forEach items="${cars}" var="carEach">
               <div class="col-md-4">
                  <div class="car-wrap rounded ftco-animate">
                     <div class="img rounded d-flex align-items-end" style="background-image: url(${carEach.picture});">
                     </div>
                     <div class="text">
                        <h2 class="mb-0"><a href="#">${carEach.brand} ${carEach.model}</a></h2>
                        <div class="d-flex mb-3">
                           <span class="cat">${carEach.type}</span>
                           <p class="price ml-auto">${carEach.price}PLN(${carEach.priceEur}&euro;)
                              <span>/day</span>
                           </p>
                        </div>
                        <p class="d-flex mb-0 d-block">
                            <p class="d-flex mb-0 d-block"><a href="/" class="btn btn-primary py-2 mr-1">Book now</a>
                           <a href="/car-details/${carEach.id}" class="btn btn-secondary py-2 ml-1">Details</a>
                        </p>
                     </div>
                  </div>
               </div>
            </d:forEach>
         </div>
      </div>
</section>
<%@include file="dynamic/footer.jspf"%>