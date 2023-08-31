<%@include file="/WEB-INF/view/dynamic/header.jspf"%>
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
            <h2 class="mb-2">Maintenance</h2>
         </div>
      </div>
      <div class="row" style="display: flex;justify-content: center;align-items: center;">
         <div class="col-md-6">
            <a href='<c:url value="/rental-management"/>' class="btn btn-primary btn-lg btn-block">Rentals</a>
         </div>
         <div class="col-md-6">
            <a href='<c:url value="/account-management"/>' class="btn btn-primary btn-lg btn-block">Accounts</a>
         </div>
      </div>
      <br>
      <div class="row" style="display: flex;justify-content: center;align-items: center;">
         <div class="col-md-6">
            <a href='<c:url value="/place-management"/>' class="btn btn-primary btn-lg btn-block">Places</a>
         </div>
         <div class="col-md-6">
            <a href='<c:url value="/car-management"/>' class="btn btn-primary btn-lg btn-block">Cars</a>
         </div>
      </div>
   </div>
</section>
<%@include file="/WEB-INF/view/dynamic/footer.jspf"%>