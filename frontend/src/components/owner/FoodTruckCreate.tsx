import FoodTruckForm from "@components/boss/FoodTruckForm";

import { IFoodTruckForm } from "@interface/foodTruck";

const FoodTruckCreate = ({ onSubmit }: IFoodTruckForm) => {
	return (
		<FoodTruckForm onSubmit={onSubmit}>
			<span>생성</span>
		</FoodTruckForm>
	);
};

export default FoodTruckCreate;