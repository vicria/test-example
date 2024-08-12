package rest.request;

/**
 * - Задание1
 * {
 * "CardNumber":"701390",
 * "DateFrom":"",
 * "DateTo":"",
 * "MovementType":"",
 * "EntityLine":""
 * }
 */

public class Task_1 {

    private String CardNumber;
    private String DateFrom;
    private String DateTo;
    private String MovementType;
    private String EntityLine;

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public String getDateFrom() {
        return DateFrom;
    }

    public void setDateFrom(String dateFrom) {
        DateFrom = dateFrom;
    }

    public String getDateTo() {
        return DateTo;
    }

    public void setDateTo(String dateTo) {
        DateTo = dateTo;
    }

    public String getMovementType() {
        return MovementType;
    }

    public void setMovementType(String movementType) {
        MovementType = movementType;
    }

    public String getEntityLine() {
        return EntityLine;
    }

    public void setEntityLine(String entityLine) {
        EntityLine = entityLine;
    }
}

