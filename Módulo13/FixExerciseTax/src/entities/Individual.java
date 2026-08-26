package entities;

public class Individual extends TaxPayer {

    private Double healthExpenditures;

    public Individual(String name, Double anualIncome, Double heathExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = heathExpenditures;
    }

    public Double getHeathExpenditures() {
        return healthExpenditures;
    }

    public void setHeathExpenditures(Double heathExpenditures) {
        this.healthExpenditures = heathExpenditures;
    }

    @Override
    public Double tax() {
        if (getAnualIncome() < 20000) {
            return getAnualIncome() * 0.15 - healthExpenditures * 0.5;
        }
        else {
            return getAnualIncome() * 0.25 - healthExpenditures * 0.5;
        }
    }
}
