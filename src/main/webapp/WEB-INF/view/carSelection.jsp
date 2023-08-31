<%@include file="dynamic/header.jspf"%>
<section class="hero-wrap hero-wrap-2 js-fullheight" style="background-image: url('/resources/images/bg_3.jpg');" data-stellar-background-ratio="0.5">
   <div class="overlay"></div>
   <div class="container">
      <div class="row no-gutters slider-text js-fullheight align-items-end justify-content-start">
         <div class="col-md-9 ftco-animate pb-5">
            <p class="breadcrumbs"><span class="mr-2"><a href="index.jsp">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Cars <i class="ion-ios-arrow-forward"></i></span></p>
            <h1 class="mb-3 bread">Choose Your Car</h1>
         </div>
      </div>
   </div>
</section>
<section class="ftco-section bg-light">
   <form method="post" action='<c:url value="/car-selection"/>'>
      <div class="container">
         <a href='<c:url value="/"/>' class="nav-link">&#8592; Back</a>
         <div class="row">
            <div class="col-md-6">
               <div class="form-group">
                  <label class="label">Pick-up location</label>
               </div>
            </div>
            <div class="col-md-6">
               <div class="form-group">
                  <label class="label">Drop-off location</label>
               </div>
            </div>
         </div>
         <div class="row">
            <div class="col-md-6">
               <div class="form-group">
                  <select class="custom-select" name="pickUpCity">
                     <option selected value="${rental.pickUpCity.id}">${rental.pickUpCity.city}</option>
                     <d:forEach items="${pickUpCities}" var="placeEach">
                        <option value="${placeEach.id}">${placeEach.city}</option>
                     </d:forEach>
                  </select>
               </div>
            </div>
            <div class="col-md-6">
               <div class="form-group">
                  <select class="custom-select" name="dropOffCity">
                     <option selected value="${rental.dropOffCity.id}">${rental.dropOffCity.city}</option>
                     <d:forEach items="${dropOffCities}" var="placeEach">
                        <option value="${placeEach.id}">${placeEach.city}</option>
                     </d:forEach>
                  </select>
               </div>
            </div>
         </div>
         <div class="row">
            <div class="col-md-6">
               <div class="form-group">
                  <label class="label">Pick-up date</label>
               </div>
            </div>
            <div class="col-md-6">
               <div class="form-group">
                  <label class="label">Drop-off date</label>
               </div>
            </div>
         </div>
         <div class="row">
            <div class="col-md-6">
               <div class="form-group">
                  <input type="text" class="form-control" id="book_pick_date" value="${rental.startDate}"
                     name="startDate" required autocomplete="off">
               </div>
            </div>
            <div class="col-md-6">
               <div class="form-group">
                  <input type="text" class="form-control" id="book_off_date" value="${rental.endDate}"
                     name="endDate" required autocomplete="off">
               </div>
            </div>
         </div>
         <div class="row">
            <div class="col-md-12">
               <div class="form-group">
                  <input type="submit" value="Change rent details" class="btn btn-secondary btn-lg btn-block">
               </div>
            </div>
         </div>
      </div>
      <input type="hidden" id="carId" name="carId">
      <br>
      <div class="container">
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
                        <div class="row">
                           <div class="col-md-6">
                              <input type="submit" value="Book now" class="btn btn-primary btn-lg btn-block" onclick="setvar('${carEach.id}');">
                           </div>
                           <div class="col-md-6">
                              <input type="button" value="Details" class="btn btn-secondary btn-lg btn-block" onclick="window.open('/car-details/${carEach.id}')">
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </d:forEach>
         </div>
      </div>
   </form>
</section>
<%@include file="dynamic/footer.jspf"%>
<script>
   function setvar(id)
   {
   	carId.value=id;
   }
</script>