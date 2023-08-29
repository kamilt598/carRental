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
      <div class="row justify-content-center">
         <div class="col-md-12 heading-section text-center ftco-animate mb-5">
            <h2 class="mb-2">Rentals</h2>
         </div>
      </div>
      <table class="table table-bordered">
         <thead>
            <tr>
               <th scope="col">User</th>
               <th scope="col">Car</th>
               <th scope="col">Pick-up date</th>
               <th scope="col">Drop-off date</th>
               <th scope="col">Pick-up location</th>
               <th scope="col">Drop-off location</th>
               <th scope="col"></th>
            </tr>
         </thead>
         <tbody>
            <form method="post" action='<c:url value="/rental-management"/>'>
               <d:forEach items="${rentalsList}" var="rentalsEach">
                  <tr>
                     <td>${rentalsEach.userId.nick}</td>
                     <td>${rentalsEach.carId.brand} ${rentalsEach.carId.model}</td>
                     <td>${rentalsEach.startDate}</td>
                     <td>${rentalsEach.endDate}</td>
                     <td>${rentalsEach.pickUpCity.city}</td>
                     <td>${rentalsEach.dropOffCity.city}</td>
                     <td><input type="submit" value="Cancel the rental" class="btn btn-danger btn-lg btn-block" onclick="setvar('${rentalsEach.id}');"></td>
                  </tr>
               </d:forEach>
            </form>
         </tbody>
      </table>
   </div>
</section>
<%@include file="dynamic/footer.jspf"%>
<script>
   function setvar(id)
   {
   	rentalId.value=id;
   }
</script>