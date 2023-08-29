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
            <h2 class="mb-2">Places</h2>
            <h3 class="mb-2" style="color:red;">${error}</h3>
         </div>
      </div>
      <table class="table table-bordered">
         <thead>
            <tr>
               <th scope="col">City</th>
               <th scope="col"></th>
            </tr>
         </thead>
         <tbody>
            <d:forEach items="${placeList}" var="placeEach">
               <tr>
                  <td>${placeEach.city}</td>
                  <td><a href='<c:url value="/delete-place/${placeEach.city}"/>' class="btn btn-danger btn-lg btn-block">Delete</a></td>
               </tr>
            </d:forEach>
            <form method="post" action='<c:url value="/place-management"/>'>
               <tr>
                  <td><input type="text" class="form-control" placeholder="City" name="newCity"></td>
                  <td><input type="submit" value="Save" class="btn btn-secondary btn-lg btn-block"></td>
               </tr>
            </form>
         </tbody>
      </table>
   </div>
</section>
<%@include file="dynamic/footer.jspf"%>