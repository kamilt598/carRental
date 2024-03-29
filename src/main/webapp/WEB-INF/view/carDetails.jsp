<%@include file="dynamic/header.jspf"%>
<section class="hero-wrap hero-wrap-2 js-fullheight" style="background-image: url('/resources/images/bg_3.jpg');" data-stellar-background-ratio="0.5">
   <div class="overlay"></div>
   <div class="container">
      <div class="row no-gutters slider-text js-fullheight align-items-end justify-content-start">
         <div class="col-md-9 ftco-animate pb-5">
            <p class="breadcrumbs"><span class="mr-2"><a href="home.jsp">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Car details <i class="ion-ios-arrow-forward"></i></span></p>
            <h1 class="mb-3 bread">Car Details</h1>
         </div>
      </div>
   </div>
</section>
<section class="ftco-section ftco-car-details">
   <div class="container">
      <a href='<c:url value="/car"/>' class="nav-link">&#8592; Back</a>
      <div class="row justify-content-center">
         <div class="col-md-12">
            <div class="car-details">
               <div class="img rounded" style="background-image: url(${car.picture});"></div>
               <div class="text text-center">
                  <h2>${car.brand} ${car.model}</h2>
               </div>
            </div>
         </div>
      </div>
      <div class="row">
         <div class="col-md d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services">
               <div class="media-body py-md-4">
                  <div class="d-flex mb-3 align-items-center">
                     <div class="text">
                        <h3 class="heading mb-0 pl-3">
                           Engine
                           <span>${car.engine}</span>
                        </h3>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         <div class="col-md d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services">
               <div class="media-body py-md-4">
                  <div class="d-flex mb-3 align-items-center">
                     <div class="text">
                        <h3 class="heading mb-0 pl-3">
                           Production Year
                           <span>${car.productionYear}</span>
                        </h3>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         <div class="col-md d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services">
               <div class="media-body py-md-4">
                  <div class="d-flex mb-3 align-items-center">
                     <div class="text">
                        <h3 class="heading mb-0 pl-3">
                           Color
                           <span>${car.color}</span>
                        </h3>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         <div class="col-md d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services">
               <div class="media-body py-md-4">
                  <div class="d-flex mb-3 align-items-center">
                     <div class="text">
                        <h3 class="heading mb-0 pl-3">
                           Type
                           <span>${car.type}</span>
                        </h3>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <div class="row">
         <div class="col-md-12 pills">
            <div class="bd-example bd-example-tabs">
               <div class="d-flex justify-content-center">
                  <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                     <li class="nav-item">
                        <a class="nav-link active" id="pills-description-tab" data-toggle="pill" href="#pills-description" role="tab" aria-controls="pills-description" aria-expanded="true">Features</a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" id="pills-manufacturer-tab" data-toggle="pill" href="#pills-manufacturer" role="tab" aria-controls="pills-manufacturer" aria-expanded="true">Description</a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" id="pills-review-tab" data-toggle="pill" href="#pills-review" role="tab" aria-controls="pills-review" aria-expanded="true">Review</a>
                     </li>
                  </ul>
               </div>
               <div class="tab-content" id="pills-tabContent">
                  <div class="tab-pane fade show active" id="pills-description" role="tabpanel" aria-labelledby="pills-description-tab">
                     <div class="row">
                        <div class="col-md-4">
                           <ul class="features">
                              <li class="check"><span class="ion-ios-checkmark"></span>Airconditions</li>
                              <li class="check"><span class="ion-ios-checkmark"></span>Child Seat</li>
                              <li class="check"><span class="ion-ios-checkmark"></span>GPS</li>
                              <li class="check"><span class="ion-ios-checkmark"></span>Luggage</li>
                              <li class="check"><span class="ion-ios-checkmark"></span>Music</li>
                           </ul>
                        </div>
                        <div class="col-md-4">
                           <ul class="features">
                              <li class="check"><span class="ion-ios-checkmark"></span>Seat Belt</li>
                              <li class="remove"><span class="ion-ios-close"></span>Sleeping Bed</li>
                              <li class="check"><span class="ion-ios-checkmark"></span>Water</li>
                              <li class="check"><span class="ion-ios-checkmark"></span>Bluetooth</li>
                              <li class="remove"><span class="ion-ios-close"></span>Onboard computer</li>
                           </ul>
                        </div>
                        <div class="col-md-4">
                           <ul class="features">
                              <li class="check"><span class="ion-ios-checkmark"></span>Audio input</li>
                              <li class="check"><span class="ion-ios-checkmark"></span>Long Term Trips</li>
                              <li class="check"><span class="ion-ios-checkmark"></span>Car Kit</li>
                              <li class="check"><span class="ion-ios-checkmark"></span>Remote central locking</li>
                              <li class="check"><span class="ion-ios-checkmark"></span>Climate control</li>
                           </ul>
                        </div>
                     </div>
                  </div>
                  <div class="tab-pane fade" id="pills-manufacturer" role="tabpanel" aria-labelledby="pills-manufacturer-tab">
                     <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.</p>
                     <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then she continued her way.</p>
                  </div>
                  <div class="tab-pane fade" id="pills-review" role="tabpanel" aria-labelledby="pills-review-tab">
                     <div class="row">
                        <div class="col-md-7">
                           <h3 class="head">23 Reviews</h3>
                           <div class="review d-flex">
                              <div class="user-img" style="background-image: url(/resources/images/person_1.jpg)"></div>
                              <div class="desc">
                                 <h4>
                                    <span class="text-left">Jacob Webb</span>
                                    <span class="text-right">14 March 2018</span>
                                 </h4>
                                 <p class="star">
                                    <span>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    </span>
                                    <span class="text-right"><a href="#" class="reply"><i class="icon-reply"></i></a></span>
                                 </p>
                                 <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrov</p>
                              </div>
                           </div>
                           <div class="review d-flex">
                              <div class="user-img" style="background-image: url(/resources/images/person_2.jpg)"></div>
                              <div class="desc">
                                 <h4>
                                    <span class="text-left">Jacob Webb</span>
                                    <span class="text-right">14 March 2018</span>
                                 </h4>
                                 <p class="star">
                                    <span>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    </span>
                                    <span class="text-right"><a href="#" class="reply"><i class="icon-reply"></i></a></span>
                                 </p>
                                 <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrov</p>
                              </div>
                           </div>
                           <div class="review d-flex">
                              <div class="user-img" style="background-image: url(/resources/images/person_3.jpg)"></div>
                              <div class="desc">
                                 <h4>
                                    <span class="text-left">Jacob Webb</span>
                                    <span class="text-right">14 March 2018</span>
                                 </h4>
                                 <p class="star">
                                    <span>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    </span>
                                    <span class="text-right"><a href="#" class="reply"><i class="icon-reply"></i></a></span>
                                 </p>
                                 <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrov</p>
                              </div>
                           </div>
                        </div>
                        <div class="col-md-5">
                           <div class="rating-wrap">
                              <h3 class="head">Give a Review</h3>
                              <div class="wrap">
                                 <p class="star">
                                    <span>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    (98%)
                                    </span>
                                    <span>20 Reviews</span>
                                 </p>
                                 <p class="star">
                                    <span>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    (85%)
                                    </span>
                                    <span>10 Reviews</span>
                                 </p>
                                 <p class="star">
                                    <span>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    (70%)
                                    </span>
                                    <span>5 Reviews</span>
                                 </p>
                                 <p class="star">
                                    <span>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    (10%)
                                    </span>
                                    <span>0 Reviews</span>
                                 </p>
                                 <p class="star">
                                    <span>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    <i class="ion-ios-star"></i>
                                    (0%)
                                    </span>
                                    <span>0 Reviews</span>
                                 </p>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
</section>
<section class="ftco-section ftco-no-pt">
   <div class="container">
      <div class="row justify-content-center">
         <div class="col-md-12 heading-section text-center ftco-animate mb-5">
            <span class="subheading">Choose Car</span>
            <h2 class="mb-2">Related Cars</h2>
         </div>
      </div>
       <div class="row">
          <div class="col-md-12">
             <div class="carousel-car owl-carousel">
                <d:forEach items="${cars}" var="carEach">
                   <div class="item">
                      <div class="car-wrap rounded ftco-animate">
                         <div class="img rounded d-flex align-items-end"
                            style="background-image: url(${carEach.picture});">
                         </div>
                         <div class="text">
                            <h2 class="mb-0"><a href="#">${carEach.brand} ${carEach.model}</a></h2>
                            <div class="d-flex mb-3">
                                                       <span class="cat">${carEach.type}</span>
                                                       <p class="price ml-auto">${carEach.price}PLN(${carEach.priceEur}&euro;)
                                                          <span>/day</span>
                                                       </p>
                                                    </div>
                            <p class="d-flex mb-0 d-block"><a href="/" class="btn btn-primary py-2 mr-1">Book
                               now</a> <a href="/car-details/${carEach.id}" class="btn btn-secondary py-2 ml-1">Details</a>
                            </p>
                         </div>
                      </div>
                   </div>
                </d:forEach>
             </div>
          </div>
       </div>
   </div>
</section>
<%@include file="dynamic/footer.jspf"%>