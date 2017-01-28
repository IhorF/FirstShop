package ua.com.library.dto;

import java.util.ArrayList;
import java.util.List;

import ua.com.library.entity.Category;
import ua.com.library.entity.Color;
import ua.com.library.entity.Commodity;
import ua.com.library.entity.Composition;
import ua.com.library.entity.Customer;
import ua.com.library.entity.Gender;
import ua.com.library.entity.Season;
import ua.com.library.entity.Size;

public class DtoUtilMapper {
	public static List<CommodityDTO> commoditiesToCommoditiesDTO(
			List<Commodity> commodities) {

		List<CommodityDTO> commodityDTOs = new ArrayList<CommodityDTO>();

		for (Commodity commodity : commodities) {

			CommodityDTO commodityDTO = new CommodityDTO();

			commodityDTO.setArticul(commodity.getArticul());
			commodityDTO.setId(commodity.getId());
			commodityDTO.setPrice(commodity.getPrice());
			commodityDTO.setPathImage(commodity.getPathImage());

			commodityDTOs.add(commodityDTO);
		}
		return commodityDTOs;
	}

	public static List<CustomerDTO> customerToCustomersDTOs(
			List<Customer> customers) {

		List<CustomerDTO> customerDTOs = new ArrayList<CustomerDTO>();

		for (Customer customer : customers) {

			CustomerDTO customerDTO = new CustomerDTO(customer.getId(),
					customer.getName(), customer.getSurName(),
					customer.getPathImage());
			customerDTOs.add(customerDTO);

		}

		return customerDTOs;
	}

	
	public static List<CategoryDTO> categoriesToCategoriesDTO(
			List<Category> categories) {

		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();

		for (Category category : categories) {

			CategoryDTO categoryDTO = new CategoryDTO();

			categoryDTO.setName(category.getName());
			categoryDTO.setId(category.getId());
			

			categoryDTOs.add(categoryDTO);
		}
		return categoryDTOs;
	}
	
	
	public static List<GenderDTO> gendersToGendersDTO(
			List<Gender> genders) {

		List<GenderDTO> genderDTOs = new ArrayList<GenderDTO>();

		for (Gender gender : genders) {

			GenderDTO genderDTO = new GenderDTO();

			genderDTO.setName(gender.getName());
			genderDTO.setId(gender.getId());
			

			genderDTOs.add(genderDTO);
		}
		return genderDTOs;
	}
	
	
	public static List<SizeDTO> sizesToSizesDTO(
			List<Size> sizes) {

		List<SizeDTO> sizeDTOs = new ArrayList<SizeDTO>();

		for (Size size : sizes) {

			SizeDTO sizeDTO = new SizeDTO();

			sizeDTO.setName(size.getName());
			sizeDTO.setId(size.getId());
			

			sizeDTOs.add(sizeDTO);
		}
		return sizeDTOs;
	}
	
	public static List<SeasonDTO> seasonsToSeasonsDTO(
			List<Season> seasons) {

		List<SeasonDTO> seasonDTOs = new ArrayList<SeasonDTO>();

		for (Season season : seasons) {

			SeasonDTO seasonDTO = new SeasonDTO();

			seasonDTO.setName(season.getName());
			seasonDTO.setId(season.getId());
			

			seasonDTOs.add(seasonDTO);
		}
		return seasonDTOs;
	}
	
	
	public static List<CompositionDTO> compositionsToCompositionsDTO(
			List<Composition> compositions) {

		List<CompositionDTO> compositionDTOs = new ArrayList<CompositionDTO>();

		for (Composition composition : compositions) {

			CompositionDTO compositionDTO = new CompositionDTO();

			compositionDTO.setCotton(composition.getCotton());
			compositionDTO.setLycra(composition.getLycra());
			compositionDTO.setPolyamide(composition.getPolyamide());
			compositionDTO.setId(composition.getId());
			

			compositionDTOs.add(compositionDTO);
		}
		return compositionDTOs;
	}
	
	
	
	public static List<ColorDTO> colorsToColorsDTO(
			List<Color> colors) {

		List<ColorDTO> colorDTOs = new ArrayList<ColorDTO>();

		for (Color color : colors) {

			ColorDTO colorDTO = new ColorDTO();

			colorDTO.setName(color.getName());
			colorDTO.setId(color.getId());
			

			colorDTOs.add(colorDTO);
		}
		return colorDTOs;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
