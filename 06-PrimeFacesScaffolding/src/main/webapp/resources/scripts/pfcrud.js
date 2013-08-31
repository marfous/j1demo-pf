function handleSubmit(xhr, status, args, dialog) {
    if(args.validationFailed) {
        PF(dialog).effect('shake', { times:3 }, 100);
    } else {
        PF(dialog).hide();
    }
}
