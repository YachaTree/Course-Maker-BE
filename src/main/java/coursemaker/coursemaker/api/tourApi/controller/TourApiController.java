package coursemaker.coursemaker.api.tourApi.controller;

import coursemaker.coursemaker.api.tourApi.dto.TourApiResponse;
import coursemaker.coursemaker.api.tourApi.entity.TourApi;
import coursemaker.coursemaker.api.tourApi.service.TourApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/v1/tours")
@RequiredArgsConstructor
public class TourApiController {

    private final TourApiService tourApiService;

    @GetMapping
    public TourApiResponse getTourData() {
        return tourApiService.getTour();
    }

//    @GetMapping
//    public List<Tour> getAllTours() {
//        return tourService.getAllTours();
//    }

    @GetMapping("/{id}")
    public Optional<TourApi> getTourById(@PathVariable Long id) {
        return tourApiService.getTourById(id);
    }

    // 호진님이 작업하셨었던 코드
//    @GetMapping
//    public String test(Model model) {
//        String response = tourApiService.getByArea();
//        model.addAttribute("response", response);
//        return "tour-api-test";
//    }
//
//    @GetMapping
//    public String test2(Model model) {
//        AreaTourResponse response = tourApiService.getAreaTourList();
//        model.addAttribute("response", response);
//        return "tour-api-test";
//    }
}
