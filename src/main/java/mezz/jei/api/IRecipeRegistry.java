package mezz.jei.api;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeType;
import mezz.jei.api.recipe.type.IRecipeTypeKey;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * IRecipeManager is used to register new IRecipeHandlers and recipes.
 * Once registered, the IRecipeManager offers several functions for retrieving and handling recipes.
 * The IRecipeManager instance is provided in JEIManager.
 */
public interface IRecipeRegistry {

	/**
	 *  Registering Recipes
	 */

	void registerRecipeType(IRecipeTypeKey recipeTypeKey, IRecipeType recipeType);
	void registerRecipeHandlers(IRecipeHandler... recipeHandlers);
	void addRecipes(Iterable recipes);

	/**
	 *  Using Recipes
	 *  Available after JEI's FMLLoadCompleteEvent event
	 */

	/* Returns the IRecipeType if it has been registered. */
	@Nullable
	IRecipeType getRecipeType(IRecipeTypeKey recipeTypeKey);

	/* Returns the IRecipeHandler associated with the recipeClass or null if there is none */
	@Nullable
	IRecipeHandler getRecipeHandler(Class recipeClass);

	/* Returns a list of Recipe Types that have the ItemStack as an input */
	@Nonnull
	List<IRecipeType> getRecipeTypesForInput(ItemStack input);

	/* Returns a list of Recipe Types that have the ItemStack as an output */
	@Nonnull
	List<IRecipeType> getRecipeTypesForOutput(ItemStack output);

	/* Returns a list of Recipes of recipeType that have the ItemStack as an input */
	@Nonnull
	List<Object> getInputRecipes(IRecipeType recipeType, ItemStack input);

	/* Returns a list of Recipes of recipeType that have the ItemStack as an output */
	@Nonnull
	List<Object> getOutputRecipes(IRecipeType recipeType, ItemStack output);
}