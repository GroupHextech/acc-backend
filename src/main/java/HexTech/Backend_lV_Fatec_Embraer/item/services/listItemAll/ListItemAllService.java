package HexTech.Backend_lV_Fatec_Embraer.item.services.listItemAll;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import HexTech.Backend_lV_Fatec_Embraer.item.entity.Item;
import HexTech.Backend_lV_Fatec_Embraer.item.repositories.ItemRepository;
import HexTech.Backend_lV_Fatec_Embraer.item.services.listItemAll.dto.ListItemAllDto;


@Service
public class ListItemAllService  {

	@Autowired
	ItemRepository itemRepository;
	
	@PreAuthorize("hasRole('PILOT')" + "|| hasRole('EDITOR')" + "|| hasRole('ADM')")	
	public List<ListItemAllDto> execute() {
		
		List<Item> listItem = itemRepository.findAll();
		
		if (listItem==null || listItem.isEmpty()) {
			throw new Error("ItemNotExist");
		}
		
		List<ListItemAllDto> listItemAllDto = new ArrayList<ListItemAllDto>();
		
		for (Item item: listItem) {
			ListItemAllDto listItensAllDto = new ListItemAllDto();
			listItensAllDto.setName_item(item.getItemName());
			listItensAllDto.setId_item(item.getItemId());
			listItemAllDto.add(listItensAllDto);
		}
			
		return listItemAllDto;
	}

}
