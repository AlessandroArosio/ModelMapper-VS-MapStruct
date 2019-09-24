package shared.dto.meta;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import shared.dto.DedupingObjectIdResolver;

/**
 * shared.dto.meta.CurrencyDTO, created on 28/08/2019 15:22 <p>
 * @author AlessandroA
 */
@Getter
@Setter
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id", scope = CurrencyDTO.class, resolver = DedupingObjectIdResolver.class)
public class CurrencyDTO extends AbstractType {

  private static final long serialVersionUID = -779394188365443995L;

  private String currencyCode;
}
