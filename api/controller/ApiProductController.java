package com.bvdev.alcoholproject.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bvdev.alcoholproject.api.dao.ApiActivityDao;
import com.bvdev.alcoholproject.api.dao.ApiProductDao;
import com.bvdev.alcoholproject.api.dto.ProductActivityDto;
import com.bvdev.alcoholproject.api.dto.ProductDto;
import com.bvdev.alcoholproject.api.dto.ProductLikeDto;
import com.bvdev.alcoholproject.api.dto.ProductParamDto;
import com.bvdev.alcoholproject.api.dto.ProductShopInfoDto;
import com.bvdev.alcoholproject.common.util.MemberUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@MultipartConfig

public class ApiProductController {
	@Inject
	private ApiProductDao apiProductDao;
	
	@Inject ApiActivityDao apiActivityDao;
	
	@Inject
	private MemberUtil memberUtil;

	@ApiOperation(value = "SELECT TBL_PRODUCT ACTIVITY", notes = "SELECT TBL_PRODUCT ACTIVITY")
	@GetMapping(value = "/product/activity/order")
	public Map<String, Object> selectProductActivityByOrder(
		@RequestParam int productIdx,
		@RequestParam Boolean orderFlg,
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {

		Boolean productActivityResultFlg = false;
		
		HttpSession session = request.getSession();
		int memberIdx = (int)session.getAttribute("idx");
		
		ProductParamDto productParamDto = new ProductParamDto();
		productParamDto.setMemberIdx(memberIdx);
		productParamDto.setProductIdx(productIdx);
		productParamDto.setOrderFlg(orderFlg);
		
		List<ProductActivityDto> productActivityDtoList = apiProductDao.selectProductActivityList(productParamDto);
		if (productActivityDtoList.size() > 0) {
			productActivityResultFlg = true;
		}

		Map<String, Object> apiResult = new HashMap<String, Object>();
		
		if (productActivityResultFlg == true) {
			apiResult.put("result", "200");
			apiResult.put("productActivityList", productActivityDtoList);
			apiResult.put("message", "상품의 활동 정보를 정상적으로 취득했습니다.");
		} else {
			apiResult.put("result", "-1");
			apiResult.put("message", "상품의 활동 정보 취득에 실패했습니다.");
		}
		return apiResult;
	}
	
	@ApiOperation(value = "SELECT TBL_SHOP_PRODUCT INFO", notes = "SELECT TBL_SHOP_PRODUCT INFO")
	@GetMapping(value = "/product/shopInfo/order")
	public Map<String, Object> selectProductShopInfoByOrder(
		@RequestParam int productIdx,
		@RequestParam Boolean orderFlg,
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		Boolean productShopInfoResultFlg = false;
		
		ProductParamDto paramDto = new ProductParamDto();
		paramDto.setProductIdx(productIdx);
		paramDto.setOrderFlg(orderFlg);
		
		List<ProductShopInfoDto> productShopInfoDtoList = apiProductDao.selectProductShopInfoList(paramDto);
		
		if (productShopInfoDtoList.size() > 0) {
			productShopInfoResultFlg = true;
		}
		
		Map<String, Object> apiResult = new HashMap<String, Object>();
		
		if (productShopInfoResultFlg == true) {
			apiResult.put("result", "200");
			apiResult.put("shopInfoList", productShopInfoDtoList);
			apiResult.put("message", "판매처 정보를 정상적으로 취득했습니다.");
		} else {
			apiResult.put("result", "-1");
			apiResult.put("message", "판매처 정보의 취득에 실패했습니다.");
		}
		return apiResult;
	}
	
	@ApiOperation(value = "UPDATE TBL_PRODUCT LIKE", notes = "UPDATE TBL_PRODUCT LIKE")
	@PostMapping(value = "/product/modify/like")
	public Map<String, String> updateTblProductLikeNum(
		@RequestParam String memberId,		//TBL_MEMBER.id
		@RequestParam Boolean likeFlg,		//TBL_PRODUCT_LIKE 갱신용 플래그
		@RequestParam int productIdx,		//TBL_RPODUCT.idx
		HttpServletRequest request,
		HttpServletResponse response
	) throws NumberFormatException, Exception {
		
		int memberIdx = 0;
		if (memberId != null && !memberId.isEmpty()) {
			memberIdx = memberUtil.getMemberIdx(memberId);
		}
		
		Boolean tblProductLikeResultFlg = false;
		Boolean tblProductResultFlg = false;
		
		int likeNum = 0;
		String likeImg = "";
		if (productIdx > 0) {
			ProductLikeDto paramDto = new ProductLikeDto();
			paramDto.setProductIdx(productIdx);
			paramDto.setMemberIdx(memberIdx);
			paramDto.setCreater(memberId);
			paramDto.setUpdater(memberId);
			
			int likeCnt = -1;
			
			if (likeFlg == true) {
				likeCnt = apiProductDao.deleteTblProductLike(paramDto);
				likeImg = "/alcoholProject/images/common/empty_heart.svg";
			} else {
				likeCnt = apiProductDao.insertTblProductLike(paramDto);
				likeImg = "/alcoholProject/images/common/full_heart.svg";
			}
			
			if (likeCnt > 0) {
				tblProductLikeResultFlg = true;
				
				ProductDto productDto = new ProductDto();
				productDto.setIdx(productIdx);
				productDto.setLikeFlg(likeFlg);
				
				int resultCnt = apiProductDao.updateTblProductByIdx(productDto);
				if (resultCnt > 0) {
					tblProductResultFlg = true;
					likeNum = apiProductDao.selectTblProductLikeNumByIdx(productIdx);
				}
			}
		}
		
		Map<String, String> apiResult = new HashMap<>();
		
		if (tblProductLikeResultFlg == true && tblProductResultFlg == true) {
			apiResult.put("result", "200");
			apiResult.put("productIdx", String.valueOf(productIdx));
			apiResult.put("likeNum", String.valueOf(likeNum));
			apiResult.put("likeImg", likeImg);
			apiResult.put("message", "상품의 좋아요가 정상적으로 갱신되었습니다.");
		} else {
			apiResult.put("result", "-1");
			apiResult.put("message", "상품의 좋아요 변경에 실패했습니다.");
		}
		return apiResult;
	}
}	