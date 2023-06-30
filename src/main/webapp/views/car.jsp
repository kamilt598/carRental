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
                           <p class="price ml-auto">${carEach.price}PLN(${carEach.priceUsd}$)
                              <span>/day</span>
                           </p>
                        </div>
                        <p class="d-flex mb-0 d-block">
                           <input type="submit" value="Book now" class="btn btn-primary py-2 mr-1" onclick="setvar('${carEach.id}');">
                           <a href="car-single.jsp" class="btn btn-secondary py-2 ml-1">Details</a>
                        </p>
                     </div>
                  </div>
               </div>
            </d:forEach>
         </div>
         <div class="row mt-5">
            <div class="col text-center">
               <div class="block-27">
                  <ul>
                     <li><a href="#">&lt;</a></li>
                     <li class="active"><span>1</span></li>
                     <li><a href="#">2</a></li>
                     <li><a href="#">3</a></li>
                     <li><a href="#">4</a></li>
                     <li><a href="#">5</a></li>
                     <li><a href="#">&gt;</a></li>
                  </ul>
               </div>
            </div>
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