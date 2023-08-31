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
      <a href='<c:url value="/car-management"/>' class="nav-link">&#8592; Back</a>
      <div class="row justify-content-center">
         <div class="col-md-12 heading-section text-center ftco-animate mb-5">
            <h2 class="mb-2">Car</h2>
            <h3 class="mb-2" style="color:red;">${error}</h3>
         </div>
      </div>
      <form method="post" action='<c:url value="/edit-car/${car.id}"/>'>
         <div class="row" style="display: flex;justify-content: center;align-items: center;">
            <div class="col-md-5">
               <h4 align="center">Brand</h4>
            </div>
            <div class="col-md-7">
               <input type="text" class="form-control" value="${car.brand}" name="brand" required>
            </div>
         </div>
         <hr style="height:2px;border-width:0;color:gray;background-color:gray">
         <div class="row" style="display: flex;justify-content: center;align-items: center;">
            <div class="col-md-5">
               <h4 align="center">Model</h4>
            </div>
            <div class="col-md-7">
               <input type="text" class="form-control" value="${car.model}" name="model" required>
            </div>
         </div>
         <hr style="height:2px;border-width:0;color:gray;background-color:gray">
         <div class="row" style="display: flex;justify-content: center;align-items: center;">
            <div class="col-md-5">
               <h4 align="center">Color</h4>
            </div>
            <div class="col-md-7">
               <input type="text" class="form-control" value="${car.color}" name="color" required>
            </div>
         </div>
         <hr style="height:2px;border-width:0;color:gray;background-color:gray">
         <div class="row" style="display: flex;justify-content: center;align-items: center;">
            <div class="col-md-5">
               <h4 align="center">Engine</h4>
            </div>
            <div class="col-md-7">
               <input type="text" class="form-control" value="${car.engine}" name="engine" required>
            </div>
         </div>
         <hr style="height:2px;border-width:0;color:gray;background-color:gray">
         <div class="row" style="display: flex;justify-content: center;align-items: center;">
            <div class="col-md-5">
               <h4 align="center">Price</h4>
            </div>
            <div class="col-md-7">
               <input type="number" class="form-control" value="${car.price}" name="price" required>
            </div>
         </div>
         <hr style="height:2px;border-width:0;color:gray;background-color:gray">
         <div class="row" style="display: flex;justify-content: center;align-items: center;">
            <div class="col-md-5">
               <h4 align="center">Production year</h4>
            </div>
            <div class="col-md-7">
               <input type="text" class="form-control" value="${car.productionYear}" name="productionYear" required>
            </div>
         </div>
         <hr style="height:2px;border-width:0;color:gray;background-color:gray">
         <div class="row" style="display: flex;justify-content: center;align-items: center;">
            <div class="col-md-5">
               <h4 align="center">Type</h4>
            </div>
            <div class="col-md-7">
               <input type="text" class="form-control" value="${car.type}" name="type" required>
            </div>
         </div>
         <hr style="height:2px;border-width:0;color:gray;background-color:gray">
         <div class="row" style="display: flex;justify-content: center;align-items: center;">
            <div class="col-md-5">
               <h4 align="center">Picture</h4>
            </div>
            <div class="col-md-7">
               <input type="text" class="form-control" value="${car.picture}" name="picture" required>
            </div>
         </div>
         <hr style="height:2px;border-width:0;color:gray;background-color:gray">
         <div class="row" style="display: flex;justify-content: center;align-items: center;">
            <div class="col-md-5">
               <h4 align="center">Location</h4>
            </div>
            <div class="col-md-7">
               <input type="text" class="form-control" value="${car.location}" name="location" required>
            </div>
         </div>
         <hr style="height:2px;border-width:0;color:gray;background-color:gray">
         <div class="row" style="display: flex;justify-content: center;align-items: center;">
            <div class="col-md-6" align="center">
               <input type="submit" value="Save" class="btn btn-secondary px-4">
            </div>
         </div>
      </form>
   </div>
</section>
<%@include file="/WEB-INF/view/dynamic/footer.jspf"%>