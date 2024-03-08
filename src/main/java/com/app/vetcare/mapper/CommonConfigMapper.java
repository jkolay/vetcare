package com.app.vetcare.mapper;

import com.app.vetcare.model.persistence.PetDetailsDao;
import com.app.vetcare.model.persistence.TestDetailsDao;
import com.app.vetcare.model.persistence.UserDao;
import com.app.vetcare.model.request.PetDetailsRequestModel;
import com.app.vetcare.model.request.TestRequest;
import com.app.vetcare.model.request.UserRequest;
import com.app.vetcare.model.response.PetDetailsResponse;
import com.app.vetcare.model.response.TestResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * This is a mapper interface which generates the model to dao class mapping implementation and dao to response class implementation at runtime
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CommonConfigMapper {
   // @Mapping(target = "ingredient", source = "name")
    PetDetailsDao mapPetRequestToPetDetailsDao (PetDetailsRequestModel petDetailsRequestModel);



    PetDetailsResponse mapPetDetailsDaoToPetDetailsResponse(PetDetailsDao petDetailsDao);

    TestDetailsDao mapTestRequestToTestDetailsDao (TestRequest testRequest);

    TestResponse mapTestDetailsDaoToTestResponse (TestDetailsDao testDetailsDao);

    UserDao mapUserRequestModelToCustomer(UserRequest userRequestModel);

   /* RecipeDao mapCreateRecipeRequestToRecipe(CreateRecipeRequest recipeRequest);

    RecipeResponse mapRecipeToRecipeResponse(RecipeDao recipeDao);

    List<RecipeResponse> mapRecipesToRecipeResponses(List<RecipeDao> recipeList);
    RecipeDao mapUpdateRecipeRequestToRecipe(UpdateRecipeRequest updateRecipeRequest);*/

}
