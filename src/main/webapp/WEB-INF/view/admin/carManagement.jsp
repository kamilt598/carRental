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
      <a href='<c:url value="/maintenance"/>' class="nav-link">&#8592; Back</a>
      <div class="row justify-content-center">
         <div class="col-md-12 heading-section text-center ftco-animate mb-5">
            <h2 class="mb-2">Cars</h2>
            <h3 class="mb-2" style="color:red;">${error}</h3>
         </div>
      </div>
      <table class="table table-bordered">
         <thead>
            <tr>
               <th scope="col">Brand</th>
               <th scope="col">Model</th>
               <th scope="col">Color</th>
               <th scope="col">Engine</th>
               <th scope="col">Price</th>
               <th scope="col">Production year</th>
               <th scope="col">Type</th>
               <th scope="col">Picture</th>
               <th scope="col">Place</th>
               <th scope="col"></th>
               <th scope="col"></th>
            </tr>
         </thead>
         <tbody>
            <d:forEach items="${cars}" var="carEach">
               <tr>
                  <td>${carEach.brand}</td>
                  <td>${carEach.model}</td>
                  <td>${carEach.color}</td>
                  <td>${carEach.engine}</td>
                  <td>${carEach.price}</td>
                  <td>${carEach.productionYear}</td>
                  <td>${carEach.type}</td>
                  <td>${carEach.picture}</td>
                  <td>${carEach.location}</td>
                  <td><a href='<c:url value="/edit-car/${carEach.id}"/>' class="btn btn-secondary btn-lg btn-block">Edit</a></td>
                  <td><a href='<c:url value="/delete-car/${carEach.id}"/>' class="btn btn-danger btn-lg btn-block">Delete</a></td>
               </tr>
            </d:forEach>
            <form method="post" action='<c:url value="/car-management"/>'>
               <tr>
                  <td><input type="text" class="form-control" placeholder="Brand" name="brand"></td>
                  <td><input type="text" class="form-control" placeholder="Model" name="model"></td>
                  <td><input type="text" class="form-control" placeholder="Color" name="color"></td>
                  <td><input type="text" class="form-control" placeholder="Engine" name="engine"></td>
                  <td><input type="text" class="form-control" placeholder="Price" name="price"></td>
                  <td><input type="text" class="form-control" placeholder="Production year" name="productionYear"></td>
                  <td><input type="text" class="form-control" placeholder="Type" name="type"></td>
                  <td><input type="text" class="form-control" placeholder="Picture" name="picture"></td>
                  <td><input type="text" class="form-control" placeholder="City" name="city"></td>
                  <td><input type="submit" value="Save" class="btn btn-secondary btn-lg btn-block"></td>
               </tr>
            </form>
         </tbody>
      </table>
   </div>
</section>
<%@include file="/WEB-INF/view/dynamic/footer.jspf"%>