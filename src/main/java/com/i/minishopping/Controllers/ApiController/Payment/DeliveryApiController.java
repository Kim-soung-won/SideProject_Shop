package com.i.minishopping.Controllers.ApiController.Payment;

import com.i.minishopping.DTORequest.Delivery.AddDeliveryRequest;
import com.i.minishopping.DTORequest.Delivery.UpdateDeliveryRequest;
import com.i.minishopping.DTOResponse.Common.CommonResponse;
import com.i.minishopping.Domains.ENUM.DLI_STATE;
import com.i.minishopping.Domains.Payment.Delivery;
import com.i.minishopping.Services.Payment.DeliveryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeliveryApiController {
    private final DeliveryService deliveryService;

//    @PostMapping("/api/POST/delivery") //배송 등록 API
//    public ResponseEntity<AddDeliveryRequest> addDelivery(@RequestBody @Valid AddDeliveryRequest request){
//        Delivery delivery = deliveryService.saveDelivery(request);
//        return ResponseEntity.ok().body(request);
//    }

    @PostMapping("/api/PUT/delivery") //배송 상태 변경 API
    public ResponseEntity<CommonResponse> updateDelivery(@RequestBody @Valid UpdateDeliveryRequest request){
        Delivery delivery = deliveryService.findById(request.getId());
        Delivery result = deliveryService.updateState(delivery, DLI_STATE.MOVE);
        if (result == null) return ResponseEntity.ok().body(new CommonResponse(600,"상태가 업데이트되지 않았습니다."));
        return ResponseEntity.ok().body(new CommonResponse(200,"상태가 업데이트 되었습니다."));
    }
}
