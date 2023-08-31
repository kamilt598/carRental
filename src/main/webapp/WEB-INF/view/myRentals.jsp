<%@include file="dynamic/header.jspf"%>
<div class="hero-wrap ftco-degree-bg" style="background-image: url('/resources/images/bg_1.jpg');" data-stellar-background-ratio="0.5">
   <div class="overlay"></div>
   <div class="container">
      <div class="row no-gutters slider-text justify-content-start align-items-center justify-content-center">
         <div class="col-lg-8 ftco-animate">
            <div class="text w-100 text-center mb-md-5 pb-md-5">
               <h1 class="mb-4">Fast &amp; Easy Way To Rent A Car</h1>
               <p style="font-size: 18px;">CHOOSE - RENT - ENJOY!</p>
            </div>
         </div>
      </div>
   </div>
</div>
<section class="ftco-section ftco-no-pt bg-light">
   <div class="container">
      <a href='<c:url value="/"/>' class="nav-link">&#8592; Back</a>
      <div class="row justify-content-center">
         <div class="col-md-12 heading-section text-center ftco-animate mb-5">
            <h2 class="mb-2">My rentals</h2>
         </div>
      </div>
      <div class="row" style="display: flex;justify-content: center;align-items: center;">
         <div class="col-md-2">
            <h4 align="center">Car</h4>
         </div>
         <div class="col-md-2">
            <h4 align="center">Pick-up date</h4>
         </div>
         <div class="col-md-2">
            <h4 align="center">Drop-off date</h4>
         </div>
         <div class="col-md-2">
            <h4 align="center">Pick-up location</h4>
         </div>
         <div class="col-md-2">
            <h4 align="center">Drop-off location</h4>
         </div>
         <div class="col-md-2">
         </div>
      </div>
      <hr style="height:2px;border-width:0;color:gray;background-color:gray">
      <form method="post" action='<c:url value="/my-rentals"/>'>
         <input type="hidden" id="rentalId" name="rentalId">
         <d:forEach items="${rentalsList}" var="rentalsEach">
            <div class="row" style="display: flex;justify-content: center;align-items: center;">
               <div class="col-md-2">
                  <h5 align="center">${rentalsEach.carId.brand} ${rentalsEach.carId.model}</h5>
               </div>
               <div class="col-md-2">
                  <h5 align="center">${rentalsEach.startDate}</h5>
               </div>
               <div class="col-md-2">
                  <h5 align="center">${rentalsEach.endDate}</h5>
               </div>
               <div class="col-md-2">
                  <h5 align="center">${rentalsEach.pickUpCity.city}</h5>
               </div>
               <div class="col-md-2">
                  <h5 align="center">${rentalsEach.dropOffCity.city}</h5>
               </div>
               <div class="col-md-2">
                  <div class="form-group" align="center">
                     <input type="submit" value="Cancel the rental" class="btn btn-danger py-3 px-4" onclick="setvar('${rentalsEach.id}');">
                  </div>
               </div>
            </div>
            <hr>
         </d:forEach>
      </form>
   </div>
</section>
<%@include file="dynamic/footer.jspf"%>
<script>
   function setvar(id)
   {
   	rentalId.value=id;
   }
</script>